package com.javaweb.jetty.jsf.bean;

import com.nikamooz.javaweb.session7.entity.City;
import com.nikamooz.javaweb.session7.entity.Person;
import com.nikamooz.javaweb.session7.provider.CityService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "personBean")
public class PersonBean {

    Person person = new Person();

    CityService cityService = new CityService();

    public Person getPerson() {
        return person;
    }

    public List<City> getCities(){
        return cityService.getCities();
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void save(){
        System.out.println(person);
        FacesMessage facesMessage = new FacesMessage("Result", "Person Saved.");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("result", facesMessage);
    }

    public String saveAndForward(){
        System.out.println(person);
        if(true) {
            return "page1";
        }else{
            return "page2";
        }
    }
}
