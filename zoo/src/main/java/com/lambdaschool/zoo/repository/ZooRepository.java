package com.lambdaschool.zoo.repository;

import com.lambdaschool.zoo.model.Zoo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository<Zoo, Long>
{
    public Zoo findByZooname(String name);


    @Modifying
    @Query(value = "DELETE FROM telephone WHERE zooid = :zooid", nativeQuery = true)
    void deletePhoneRecordsByZooid(long zooid);

    @Modifying
    @Query(value = "DELETE FROM zooanimals WHERE zooid = :zooid", nativeQuery = true)
    void deleteZooFromAnimalRecords(long zooid);

    @Modifying
    @Query(value = "INSERT INTO zoo(zooid, zooname) VALUES(:zooid, :name)", nativeQuery = true)
    void addZoo(String name, long zooid);

    @Modifying
    @Query(value = "UPDATE zoo SET zooname = :zooname WHERE zooid = :zooid", nativeQuery = true)
    void updateZoo(String zooname, long zooid);


}
