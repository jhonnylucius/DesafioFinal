package one.digitalinnovation.gof.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public final class ClienteRepository implements CrudRepository<Cliente, Long> {

    private ClienteRepository() {
    }

    public static ClienteRepository newClienteRepository() {
        return new ClienteRepository();
    }

    @Override
    public <S extends Cliente> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Cliente> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }


    public Optional<Cliente> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Cliente> findAll() {
        return null;
    }

    @Override
    public Iterable<Cliente> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Cliente entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cliente> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
