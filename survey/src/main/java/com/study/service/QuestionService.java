package com.study.service;

import com.google.common.base.Splitter;
import com.study.entity.Question;
import com.study.entity.QuestionOpt;
import com.study.mapper.QuestionMapper;
import com.study.mapper.QuestionOptMapper;
import com.study.utils.BeanMapUtils;
import com.study.utils.MapParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionOptMapper questionOptMapper;


    public int create(Question pi){
        int flag = 0;
        if(pi.getId() != null){
            flag = this.update(pi);
            questionOptMapper.delete(MapParameter.getInstance().add("questionId",pi.getId()).getMap());
        }else{
            flag = questionMapper.create(pi);
        }
        if(flag>0){
            List<QuestionOpt> options = pi.getOptions();
            int i = 0;
            for (QuestionOpt option : options) {
                option.setSurveyId(pi.getSurveyId());
                option.setQuestionId(pi.getId());
                option.setOrderby(++i);
                questionOptMapper.create(option);
            }
        }
        return pi.getId();
    }

    public int deleteBatch(String ids){
        int flag = 0;
        List<String> list = Splitter.on(",").splitToList(ids);
        for (String s : list) {
            questionMapper.delete(MapParameter.getInstance().addId(Integer.parseInt(s)).getMap());
            questionOptMapper.delete(MapParameter.getInstance().add("questionId",Integer.parseInt(s)).getMap());
            flag++;
        }
        return flag;
    }

    public int delete(Integer id){
        return questionMapper.delete(MapParameter.getInstance().addId(id).getMap());
    }

    public int update(Question question){
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMapForUpdate(question)).addId(question.getId()).getMap();
        return questionMapper.update(map);
    }

    public List<Question> query(Question question){
        //仅仅查询的问题
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(question)).getMap();
        List<Question> questionList = questionMapper.query(map);
        List<QuestionOpt> optList = questionOptMapper.query(MapParameter.getInstance().add("surveyId", question.getSurveyId()).getMap());
        for (Question question1 : questionList) {
            List<QuestionOpt> options = new ArrayList<>();
            for (QuestionOpt questionOpt : optList) {
                if(question1.getId() == questionOpt.getQuestionId()){
                    options.add(questionOpt);
                }
            }
            question1.setOptions(options);
        }
        return questionList;
    }

    public Question detail(Integer id){
        return questionMapper.detail(MapParameter.getInstance().addId(id).getMap());
    }

    public int count(Question question){
        Map<String, Object> map = MapParameter.getInstance().put(BeanMapUtils.beanToMap(question)).getMap();
        return questionMapper.count(map);
    }

}
