package com.amico.service.im.api;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.amico.service.im.entity.model.MissuUsers;

import java.util.List;

public interface MissuUsersService  {

    /**
     * find model by primary key
     *
     * @param id
     * @return
     */
    public MissuUsers findById(Object id);


    /**
     * find all model
     *
     * @return all <MissuUsers
     */
    public List<MissuUsers> findAll();


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
    public boolean delete(MissuUsers model);


    /**
     * save model to database
     *
     * @param model
     * @return
     */
    public boolean save(MissuUsers model);


    /**
     * save or update model
     *
     * @param model
     * @return if save or update success
     */
    public boolean saveOrUpdate(MissuUsers model);


    /**
     * update data model
     *
     * @param model
     * @return
     */
    public boolean update(MissuUsers model);


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
    
    public MissuUsers iMloginService(String devType,String deviceToken,String ip,String userPhone,String pwd);

    public List<MissuUsers> findFriends(MissuUsers user);
}