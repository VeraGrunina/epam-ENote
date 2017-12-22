package generalPackage.service.impl;

import generalPackage.data.entity.Hash;
import generalPackage.exception.ApplicationRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import generalPackage.data.dao.HashDAO;
import generalPackage.service.interfaces.HashService;

@Service
public class HashServiceImpl implements HashService {

    @Autowired
    private HashDAO hashDAO;

    @Override
    public Hash createHash(Hash hash) {
        if (hash == null)
            throw new ApplicationRuntimeException("create null Hash");


        return hashDAO.save(hash);
    }

    @Override
    public Hash updateHash(Hash hash) {
        if (!hashDAO.exists(hash.getUser().getId())) {
            throw new ApplicationRuntimeException(
                    String.format("There is no hash with id %s",
                            hash.getUser().getId()));
        }
        return hashDAO.save(hash);
    }

    @Override
    public Hash readHashByUserId(Long userId) {
        if (!hashDAO.exists(userId)) {
            throw new ApplicationRuntimeException(
                    String.format("There is no hash with currentUserId %s",
                            userId));
        }
        return hashDAO.findOne(userId);
    }

    @Override
    public void deleteHash(Long userId) {
        if (!hashDAO.exists(userId)) {
            throw new ApplicationRuntimeException(
                    String.format("There is no hash with currentUserId %s",
                            userId));
        }
        hashDAO.delete(userId);
    }
}
