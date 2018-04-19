package nl.hsleiden.service;


import nl.hsleiden.model.Follower;

import nl.hsleiden.persistence.FollowerDAO;


import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class FollowerService extends BaseService<Follower>{

    private final FollowerDAO dao;

    @Inject
    public FollowerService(FollowerDAO dao)
    {
        this.dao = dao;
    }

    public Follower get(int id)
    {
        return requireResult(dao.get(id));
    }


}


