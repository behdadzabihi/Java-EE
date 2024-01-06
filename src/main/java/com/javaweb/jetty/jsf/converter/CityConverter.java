package com.javaweb.jetty.jsf.converter;

import com.nikamooz.javaweb.session7.entity.City;
import com.nikamooz.javaweb.session7.provider.CityService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cityConverter")
public class CityConverter implements Converter {

    CityService cityService = new CityService();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return cityService.getById(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if(object instanceof City){
            return String.valueOf(((City)object).getId());
        }
        return null;
    }
}
