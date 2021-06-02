package com.study.service;

import com.github.pagehelper.PageHelper;
import com.google.common.base.Splitter;
import com.study.entity.AnswerOpt;
import com.study.entity.AnswerTxt;
import com.study.entity.Survey;
import com.study.mapper.AnswerOptMapper;
import com.study.mapper.AnswerTxtMapper;
import com.study.mapper.SurveyMapper;
import com.study.utils.BeanMapUtils;
import com.study.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SurveyService {

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private AnswerTxtMapper answerTxtMapper;

    @Autowired
    private AnswerOptMapper answerOptMapper;

    public int create(Survey Survey){
        return surveyMapper.create(Survey);
    }

    public int delete(Integer id){
        return surveyMapper.delete(MapParameter.getInstance().addId(id).getMap());
    };

    public int deleteBatch(String ids){
        int flag = 0;
        List<String> list = Splitter.on(",").splitToList(ids);
        for (String s : list) {
            surveyMapper.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
            flag++;
        }
        return flag;
    };

    public int update(Survey survey){
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMapForUpdate(survey)).addId(survey.getId()).getMap();
        return surveyMapper.update(map);
    };

    public List<Survey> query(Survey survey){
        PageHelper.startPage(survey.getPage(),survey.getLimit());
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(survey)).getMap();
        return surveyMapper.query(map);
    };

    public List<Survey> queryAll(Survey survey){
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(survey)).getMap();
        return surveyMapper.query(map);
    }

    public Survey detail(Integer id){
        return surveyMapper.detail(MapParameter.getInstance().addId(id).getMap());
    };

    public int count(Survey Survey){
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(Survey)).getMap();
        return surveyMapper.count(map);
    };

    public List<AnswerOpt> queryAnswerOpt(AnswerOpt answerOpt){
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(answerOpt)).getMap();
        return answerOptMapper.query(map);
    }

    public void updateState(){
        List<Integer> list = surveyMapper.queryByState(Survey.state_create);
        for (Integer id : list) {
            surveyMapper.update(MapParameter.getInstance().add("updateState",Survey.state_exec).add("id",id).getMap());
        }
        List<Integer> list2 = surveyMapper.queryByStateForExec(Survey.state_exec);
        for (Integer id : list2) {
            surveyMapper.update(MapParameter.getInstance().add("updateState",Survey.state_over).add("id",id).getMap());
        }
    }

    public Integer submit(List<AnswerOpt> opts, List<AnswerTxt> txts){
        int flag = 0;
        for (AnswerOpt opt : opts) {
            flag = answerOptMapper.create(opt);
        }
        for (AnswerTxt txt : txts) {
            flag = answerTxtMapper.create(txt);
        }
        return flag;
    }
}
