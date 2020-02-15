package com.yt.model;


import java.sql.Date;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Pet
 * @Description 宠物模型
 * @createTime 2020年02月14日 13:39:00
 */
public class Pet {
    private int id;
    private String title;
    private int selling;
    private double price;
    private int age;
    private String type;
    private String variety;
    private String sellAddress;
    private String bornAddress;
    private String pic1;
    private String pic2;
    private String pic3;
    private String mainPic;
    private String description;
    private int visitors;
    private int questionCount;
    private int selledCount;
    private int evaluationCount;
    private int evaluationId;
    private Date addTime;
    private List<EvaluationInfo> evaluations;

    public List<EvaluationInfo> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<EvaluationInfo> evaluations) {
        this.evaluations = evaluations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSelling() {
        return selling;
    }

    public void setSelling(int selling) {
        this.selling = selling;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getSellAddress() {
        return sellAddress;
    }

    public void setSellAddress(String sellAddress) {
        this.sellAddress = sellAddress;
    }

    public String getBornAddress() {
        return bornAddress;
    }

    public void setBornAddress(String bornAddress) {
        this.bornAddress = bornAddress;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public int getSelledCount() {
        return selledCount;
    }

    public void setSelledCount(int selledCount) {
        this.selledCount = selledCount;
    }

    public int getEvaluationCount() {
        return evaluationCount;
    }

    public void setEvaluationCount(int evaluationCount) {
        this.evaluationCount = evaluationCount;
    }

    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
