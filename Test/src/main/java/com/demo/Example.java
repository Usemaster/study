package com.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;

    /**
     *
     * @author colin
     *
     * @since 2013-5-9 上午11:47:03
     */
    public class Example {
        private static final String DOMAIN = "http://api.developer.xiaomi.com/devupload";
        //推送应用到小米应用商店。
        private static final String PUSH = DOMAIN + "/dev/push";
        private static final String PUSH_CHANNEL_APK = DOMAIN + "/dev/pushChannelApk";
        //通过应用包名查询小米应用商店内本账户推送的最新应用详情，用于判断是否需要进行应用推送。
        private static final String QUERY = DOMAIN + "/dev/query";
        //查询小米应用商店的应用分类。
        private static final String CATEGORY = DOMAIN + "/dev/category";

        private static final int KEY_SIZE = 1024;
        private static final int GROUP_SIZE = KEY_SIZE / 8;
        private static final int ENCRYPT_GROUP_SIZE = GROUP_SIZE - 11;
        public static final String KEY_ALGORITHM = "RSA/NONE/PKCS1Padding";

        private static PublicKey pubKey;
        // 加载BC库
        static {
            Security.addProvider(new BouncyCastleProvider());
        }
        static {
            try {
                pubKey = getPublicKeyByX509Cer("公钥证书路径");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 公钥加密
         *
         * @param str
         * @param publicKey
         * @return
         * @throws Exception
         */
        public static String encryptByPublicKey(String str, PublicKey publicKey) throws Exception {
            byte[] data = str.getBytes();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] segment = new byte[ENCRYPT_GROUP_SIZE];
            int idx = 0;
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM, "BC");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            while (idx < data.length) {
                int remain = data.length - idx;
                int segsize = remain > ENCRYPT_GROUP_SIZE ? ENCRYPT_GROUP_SIZE : remain;
                System.arraycopy(data, idx, segment, 0, segsize);
                baos.write(cipher.doFinal(segment, 0, segsize));
                idx += segsize;
            }
            return Hex.encodeHexString(baos.toByteArray());
        }

        /**
         * 读取公钥
         *
         * @param cerFilePath
         * @return
         * @throws Exception
         */
        public static PublicKey getPublicKeyByX509Cer(String cerFilePath) throws Exception {
            InputStream x509Is = new FileInputStream(cerFilePath);
            try {
                CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");
                X509Certificate cert = (X509Certificate) certificatefactory.generateCertificate(x509Is);
                return cert.getPublicKey();
            } finally {
                if (x509Is != null) {
                    try {
                        x509Is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private static String getFileMD5(File file) throws IOException {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                return DigestUtils.md5Hex(fis);
            } finally {
                if (fis != null) {
                    fis.close();
                }
            }
        }

        /**
         * 读取应答包
         *
         * @param responseEntity
         * @return
         * @throws IOException
         */
        private static String readResponse(HttpEntity responseEntity) throws IOException {
            if (responseEntity == null) {
                return "";
            }
            StringBuffer sb = new StringBuffer();
            InputStream instream = responseEntity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
            try {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } finally {
                reader.close();
            }
            return sb.toString().trim();
        }

        /**
         * 查询分类
         *
         * @return
         */
        public String getCatetories() {
            HttpPost request = new HttpPost(CATEGORY);
            HttpClient httpClient = new DefaultHttpClient();
            try {

                HttpResponse response = httpClient.execute(request);
                HttpEntity responseEntity = response.getEntity();
                return readResponse(responseEntity);
            } catch (Exception ex) {
                ex.printStackTrace();
                request.abort();
            } finally {
                httpClient.getConnectionManager().shutdown();
            }
            return "";
        }

        /**
         * 查询应用信息
         *
         * @param packageName
         * @param userName
         * @param password
         * @return
         */
        public String query(String userName, String password, String packageName) {
            HttpClient httpClient = new DefaultHttpClient();
            try {
                JSONObject json = new JSONObject();
                json.put("packageName", packageName);
                json.put("userName", userName);
                List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
                formParams.add(new BasicNameValuePair("RequestData", json.toString()));

                JSONObject sig = new JSONObject();
                JSONArray sigs = new JSONArray();

                JSONObject sigItem = new JSONObject();
                sigItem.put("name", "RequestData");
                sigItem.put("hash", DigestUtils.md5Hex(json.toString()));

                sigs.add(sigItem);
                sig.put("sig", sigs);
                sig.put("password", password);
                formParams.add(new BasicNameValuePair("SIG", encryptByPublicKey(sig.toString(), pubKey)));
                HttpEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");

                HttpPost request = new HttpPost(QUERY);
                request.setEntity(entity);
                HttpResponse response = httpClient.execute(request);
                HttpEntity responseEntity = response.getEntity();
                return readResponse(responseEntity);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                httpClient.getConnectionManager().shutdown();
            }
            return "";
        }

        /**
         * 推送应用
         *
         * @param email
         * @param password
         * @param synchroType
         *            0：新增;1：更新;2：信息修改
         * @param apkFile
         * @param iconFile
         * @param appDetail
         * @param screenshots
         * @return
         * @throws Exception
         */
        public String push(String email, String password, int synchroType, File apkFile, File iconFile, AppDetailBean appDetail,
                           File... screenshots) throws Exception {
            HttpClient httpClient = new DefaultHttpClient();
            try {
                JSONObject json = new JSONObject();
                json.put("userName", email);
                json.put("appInfo", appDetail);
                json.put("synchroType", synchroType);

                // 计算数字签名
                JSONObject sigJSON = new JSONObject();
                JSONArray paramMd5Array = new JSONArray();
                JSONObject sigItem = new JSONObject();
                sigItem.put("name", "RequestData");
                sigItem.put("hash", DigestUtils.md5Hex(json.toString()));

                paramMd5Array.add(sigItem);

                MultipartEntity entity = new MultipartEntity();

                if (apkFile != null) {
                    JSONObject apk = new JSONObject();
                    apk.put("name", "apk");
                    apk.put("hash", getFileMD5(apkFile));
                    paramMd5Array.add(apk);
                    entity.addPart("apk", new FileBody(apkFile));
                }

                if (iconFile != null) {
                    JSONObject icon = new JSONObject();
                    icon.put("name", "icon");
                    icon.put("hash", getFileMD5(iconFile));
                    paramMd5Array.add(icon);
                    entity.addPart("icon", new FileBody(iconFile));
                }

                if (screenshots != null && screenshots.length > 0) {
                    for (int i = 0; i < screenshots.length; i++) {
                        String screenshotName = "screenshot_" + (i + 1);
                        JSONObject screenshot = new JSONObject();
                        screenshot.put("name", screenshotName);
                        screenshot.put("hash", getFileMD5(screenshots[i]));
                        paramMd5Array.add(screenshot);

                        entity.addPart(screenshotName, new FileBody(screenshots[i]));
                    }
                }
                sigJSON.put("sig", paramMd5Array);
                sigJSON.put("password", password);

                entity.addPart("RequestData", new StringBody(json.toString(), Charset.forName("UTF-8")));
                entity.addPart("SIG", new StringBody(encryptByPublicKey(sigJSON.toString(), pubKey), Charset.forName("UTF-8")));

                HttpPost request = new HttpPost(PUSH);
                request.setEntity(entity);
                HttpResponse response = httpClient.execute(request);
                HttpEntity responseEntity = response.getEntity();
                return readResponse(responseEntity);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            } finally {
                httpClient.getConnectionManager().shutdown();
            }
        }

        /*
         * 推送渠道包
         *
         * @param email
         * @param password
         * @param channelApkFile
         */
        private String pushChannelApk(String email, String password, String apkChannel, File channelApkFile) {
            HttpClient httpClient = new DefaultHttpClient();
            try {
                JSONObject json = new JSONObject();
                json.put("userName", email);
                json.put("apkChannel", apkChannel);

                // 计算数字签名
                JSONArray paramMd5Array = new JSONArray();
                JSONObject sigItem = new JSONObject();
                sigItem.put("name", "RequestData");
                sigItem.put("hash", DigestUtils.md5Hex(json.toString()));
                paramMd5Array.add(sigItem);

                MultipartEntity entity = new MultipartEntity();

                if (channelApkFile != null) {
                    JSONObject apk = new JSONObject();
                    apk.put("name", "channelApk");
                    apk.put("hash", getFileMD5(channelApkFile));
                    paramMd5Array.add(apk);
                    entity.addPart("channelApk", new FileBody(channelApkFile));
                }

                JSONObject sigJSON = new JSONObject();
                sigJSON.put("sig", paramMd5Array);
                sigJSON.put("password", password);

                entity.addPart("RequestData", new StringBody(json.toString(), Charset.forName("UTF-8")));
                entity.addPart("SIG", new StringBody(encryptByPublicKey(sigJSON.toString(), pubKey), Charset.forName("UTF-8")));

                HttpPost request = new HttpPost(PUSH_CHANNEL_APK);
                request.setEntity(entity);
                HttpResponse response = httpClient.execute(request);
                HttpEntity responseEntity = response.getEntity();
                return readResponse(responseEntity);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            } finally {
                httpClient.getConnectionManager().shutdown();
            }
        }

        public static class AppDetailBean {
            private String appName;
            private String packageName;
            private String publisherName;
            private int category;
            private String keyWords;
            private String versionName;
            private String desc;
            private String web;
            private String updateDesc;
            private String price;
            private String shortDesc;

            public String getPackageName() {
                return packageName;
            }
            public void setPackageName(String packageName) {
                this.packageName = packageName;
            }
            public String getAppName() {
                return appName;
            }
            public void setAppName(String appName) {
                this.appName = appName;
            }
            public String getPublisherName() {
                return publisherName;
            }
            public void setPublisherName(String publisherName) {
                this.publisherName = publisherName;
            }
            public int getCategory() {
                return category;
            }
            public void setCategory(int category) {
                this.category = category;
            }
            public String getKeyWords() {
                return keyWords;
            }
            public void setKeyWords(String keyWords) {
                this.keyWords = keyWords;
            }
            public String getVersionName() {
                return versionName;
            }
            public void setVersionName(String versionName) {
                this.versionName = versionName;
            }
            public String getDesc() {
                return desc;
            }
            public void setDesc(String desc) {
                this.desc = desc;
            }
            public String getWeb() {
                return web;
            }
            public void setWeb(String web) {
                this.web = web;
            }
            public String getUpdateDesc() {
                return updateDesc;
            }
            public void setUpdateDesc(String updateDesc) {
                this.updateDesc = updateDesc;
            }
            public String getPrice() {
                return price;
            }
            public void setPrice(String price) {
                this.price = price;
            }
            public String getShortDesc() {
                return shortDesc;
            }
            public void setShortDesc(String shortDesc) {
                this.shortDesc = shortDesc;
            }
        }

        public static void main(String[] args) throws Exception {
            Example example = new Example();
            String email = "";
            String pwd = "";

            // 查询分类
            String category = example.getCatetories();
            System.out.println(category);

            // 查询应用信息
            String info = example.query(email, pwd, "应用的包名");
            System.out.println("详情[" + info + "]");

            // 推送数据
            AppDetailBean appDetail = new AppDetailBean();
            appDetail.setAppName("应用名称");
            appDetail.setCategory(2);
            appDetail.setDesc("应用详情");
            appDetail.setPackageName("应用包名");
            appDetail.setKeyWords("关键字1 关键字2");
            appDetail.setWeb("应用官网");

            File apkFile = new File("apk文件路径");
            File iconFile = new File("图标文件路径");

            File screenshot_1File = new File("截图1路径");
            File screenshot_2File = new File("截图2路径");
            File screenshot_3File = new File("截图3路径");

            File[] screenshots = {screenshot_1File, screenshot_2File, screenshot_3File};
            String result = example.push(email, pwd, 0, apkFile, iconFile, appDetail, screenshots);
            System.out.println("结果[" + result + "]");

            // 提交渠道包
            String apkChannel = "渠道名称";
            File channelApkFile = new File("渠道包路径");
            String channelApkResult = example.pushChannelApk(email, pwd, apkChannel, channelApkFile);
            System.out.println("结果[" + channelApkResult + "]");
        }
    }
