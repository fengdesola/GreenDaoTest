package com.aaa.greendaotest.dbhelper.base;

import android.support.annotation.NonNull;

import com.aaa.greendaotest.dbhelper.DatabaseManager;
import com.aaa.greendaotest.greendao.DaoSession;

import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;



public class OperatorHelper {

    /**
     * 插入单条
     *
     * @param manager
     * @param entity
     * @param <T>
     * @return
     */
    public static <T> long insert(@NonNull DatabaseManager manager, T entity) {
        if (entity == null) {
            return -1;
        }
//        synchronized (manager) {
        DaoSession daoSession = manager.getDaoSession();
        long flag = -1;
        try {
            flag = daoSession.insertOrReplace(entity);
        } catch (Exception e) {
            e.printStackTrace();
            flag = -1;
        }
        return flag;
//        }
    }


    /**
     * 插入多条，异步
     *
     * @param manager
     * @param clazz
     * @param entities
     * @param <T>
     */
    public static <T> void insert(@NonNull DatabaseManager manager, final Class<T> clazz, final List<T> entities) {
        if (entities == null || entities.isEmpty()) {
            return;
        }
//        synchronized (manager) {
        final AsyncSession daoSession = manager.getDaoSession().startAsyncSession();
        try {
            daoSession.runInTx(new Runnable() {
                @Override
                public void run() {
                    daoSession.insertOrReplaceInTx(clazz, entities);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
//        }
    }

    /**
     * 更新单条
     *
     * @param manager
     * @param entity
     * @param <T>
     * @return
     */
    public static <T> boolean update(@NonNull DatabaseManager manager, final T entity) {
        if (entity == null) {
            return false;
        }
//        synchronized (manager) {
        DaoSession daoSession = manager.getDaoSession();
        boolean flag = false;
        try {
            daoSession.update(entity);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
//        }
    }

    /**
     * 删除单条
     *
     * @param manager
     * @param entity
     * @param <T>
     * @return
     */
    public static <T> boolean delete(@NonNull DatabaseManager manager, final T entity) {
        if (entity == null) {
            return false;
        }
//        synchronized (manager) {
        final DaoSession daoSession = manager.getDaoSession();
        boolean flag = false;
        try {
            daoSession.delete(entity);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
//        }
    }

    /**
     * 删除多条，异步
     *
     * @param manager
     * @param entities
     * @param <T>
     */
    public static <T> void delete(@NonNull DatabaseManager manager, final Class<T> clazz, final List<T> entities) {
        if (entities == null || entities.isEmpty()) {
            return;
        }
        final AsyncSession daoSession = manager.getDaoSession().startAsyncSession();
        try {
            daoSession.runInTx(new Runnable() {
                @Override
                public void run() {
                    daoSession.deleteInTx(clazz, entities);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除全部
     *
     * @param manager
     * @param clazz
     * @return
     */
    public static boolean deleteAll(@NonNull DatabaseManager manager, final Class clazz) {
        if (clazz == null) {
            return false;
        }
        final AsyncSession daoSession = manager.getDaoSession().startAsyncSession();
        try {
            daoSession.runInTx(new Runnable() {
                @Override
                public void run() {
                    daoSession.deleteAll(clazz);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 查询
     *
     * @param manager
     * @param builder
     * @param <T>
     * @return
     */
    public static <T> List<T> query(@NonNull DatabaseManager manager, @NonNull QueryBuilder<T> builder) {
        if (builder == null) {
            return null;
        }
        Query<T> query = builder.build().forCurrentThread();
        return query.list();
    }

}
