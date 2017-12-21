package generalPackage.config.services.impl;

import generalPackage.config.exception.ApplicationRuntimeException;
import generalPackage.config.model.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import generalPackage.config.repositories.HashRepository;
import generalPackage.config.services.interfaces.HashService;

@Service
public class HashServiceImpl implements HashService {

    @Autowired
    private HashRepository hashRepository;

    @Override
    public Hash createHash(Hash hash) {
        if (hash == null)
            throw new ApplicationRuntimeException("create null Hash");

        return hashRepository.save(hash);
    }

    @Override
    public Hash updateHash(Hash hash) {
        if (!hashRepository.exists(hash.getUser().getId())) {
            throw new ApplicationRuntimeException(
                    String.format("There is no hash with id %s",
                            hash.getUser().getId()));
        }
        return hashRepository.save(hash);
    }

    @Override
    public Hash readHashByUserId(Long userId) {
        if (!hashRepository.exists(userId)) {
            throw new ApplicationRuntimeException(
                    String.format("There is no hash with currentUserId %s",
                            userId));
        }
        return hashRepository.findOne(userId);
    }

    @Override
    public void deleteHash(Long userId) {
        if (!hashRepository.exists(userId)) {
            throw new ApplicationRuntimeException(
                    String.format("There is no hash with currentUserId %s",
                            userId));
        }
        hashRepository.delete(userId);
    }
}
