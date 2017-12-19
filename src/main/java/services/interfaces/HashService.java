package services.interfaces;

import model.Hash;

public interface HashService {

    Hash createHash(Hash hash);

    Hash updateHash(Hash hash);

    Hash readHashByUserId(Long userId);

    void deleteHash(Long userId);

}
