package com.amico.service.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.amico.service.entity.model.AuthToken;

import java.util.List;

public interface AuthTokenService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public AuthToken findById(Object id);


    /**
     * find all model
     *
     * @return all <AuthToken
     */
    public List<AuthToken> findAll();


    /**
     * delete model by primary key
     *
     * @param id
     * @return success
     */
    public boolean deleteById(Object id);


    /**
     * delete model
     *
     * @param model
     * @return
     */
    public boolean delete(AuthToken model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(AuthToken model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(AuthToken model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(AuthToken model);


    /**
     * 分页
     *
     * @param page
     * @param pageSize
     * @return
     */
    public Page<? extends Model> paginate(int page, int pageSize);


    public void join(Page<? extends Model> page, String joinOnField);

    public void join(Page<? extends Model> page, String joinOnField, String[] attrs);

    public void join(Page<? extends Model> page, String joinOnField, String joinName);

    public void join(Page<? extends Model> page, String joinOnField, String joinName, String[] attrs);

    public void join(List<? extends Model> models, String joinOnField);

    public void join(List<? extends Model> models, String joinOnField, String[] attrs);

    public void join(List<? extends Model> models, String joinOnField, String joinName);

    public void join(List<? extends Model> models, String joinOnField, String joinName, String[] attrs);

    public void join(Model model, String joinOnField);

    public void join(Model model, String joinOnField, String[] attrs);

    public void join(Model model, String joinOnField, String joinName);

    public void join(Model model, String joinOnField, String joinName, String[] attrs);

    public void keep(Model model, String... attrs);

    public void keep(List<? extends Model> models, String... attrs);
    
    public AuthToken findBySessionId(String sessionId);
    
    public Page<AuthToken> findPage(AuthToken authToken, int pageNumber, int pageSize) ;

}