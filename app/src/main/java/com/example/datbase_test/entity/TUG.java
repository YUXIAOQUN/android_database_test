package com.example.datbase_test.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.ToOne;

import java.time.LocalDateTime;

@Entity
public class TUG {
    @Id(autoincrement = true)
    private Long id;
    private Float time;
    private Float new_feature;
    private Float new_feature_2;
    private Float new_feature_3;
    private Long finish_date_time;
    private Long userId;

    @ToOne(joinProperty = "userId")
    private User user;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 463110202)
    private transient TUGDao myDao;

    @Generated(hash = 1304201904)
    public TUG(Long id, Float time, Float new_feature, Float new_feature_2,
            Float new_feature_3, Long finish_date_time, Long userId) {
        this.id = id;
        this.time = time;
        this.new_feature = new_feature;
        this.new_feature_2 = new_feature_2;
        this.new_feature_3 = new_feature_3;
        this.finish_date_time = finish_date_time;
        this.userId = userId;
    }

    @Generated(hash = 628896883)
    public TUG() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTime() {
        return this.time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public Float getNew_feature() {
        return this.new_feature;
    }

    public void setNew_feature(Float new_feature) {
        this.new_feature = new_feature;
    }

    public Float getNew_feature_2() {
        return this.new_feature_2;
    }

    public void setNew_feature_2(Float new_feature_2) {
        this.new_feature_2 = new_feature_2;
    }

    public Long getFinish_date_time() {
        return this.finish_date_time;
    }

    public void setFinish_date_time(Long finish_date_time) {
        this.finish_date_time = finish_date_time;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(hash = 251390918)
    private transient Long user__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 859885876)
    public User getUser() {
        Long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1065606912)
    public void setUser(User user) {
        synchronized (this) {
            this.user = user;
            userId = user == null ? null : user.getId();
            user__resolvedKey = userId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public Float getNew_feature_3() {
        return this.new_feature_3;
    }

    public void setNew_feature_3(Float new_feature_3) {
        this.new_feature_3 = new_feature_3;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1987586069)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTUGDao() : null;
    }

}
