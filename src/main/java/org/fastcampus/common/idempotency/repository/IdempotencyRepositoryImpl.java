package org.fastcampus.common.idempotency.repository;

import lombok.RequiredArgsConstructor;
import org.fastcampus.common.idempotency.Idempotency;
import org.fastcampus.common.idempotency.IdempotencyRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class IdempotencyRepositoryImpl implements IdempotencyRepository {

    @Override
    public Idempotency getByKey(String key) {
        return null;
    }

    @Override
    public void save(Idempotency idempotency) {

    }
}
