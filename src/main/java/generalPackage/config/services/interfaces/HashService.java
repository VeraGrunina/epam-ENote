package generalPackage.config.services.interfaces;

import generalPackage.config.model.Hash;

public interface HashService {

    Hash createHash(Hash hash);

    Hash updateHash(Hash hash);

    Hash readHashByUserId(Long userId);

    void deleteHash(Long userId);

}
