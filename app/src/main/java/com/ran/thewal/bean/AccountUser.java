package com.ran.thewal.bean;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Slim Shady on 2017/11/18.
 */
public class AccountUser extends BmobUser {
    private String sex;
    private Integer age;
    private BmobFile authThumb;
    private String collage;
    private String class2num;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BmobFile getAuthThumb() {
        return authThumb;
    }

    public void setAuthThumb(BmobFile authThumb) {
        this.authThumb = authThumb;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

}
