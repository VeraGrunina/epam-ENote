package generalPackage.service.interfaces;

import generalPackage.data.entity.Hash;

public interface HashService {

    Hash createHash(Hash hash);

    Hash updateHash(Hash hash);

    Hash readHashByUserId(Long userId);

    void deleteHash(Long userId);

}
