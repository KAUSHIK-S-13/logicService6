package com.coherent.unnamed.logic.repository;

import com.coherent.unnamed.logic.model.TimeLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TimeLogsRepository  extends JpaRepository<TimeLogs, Long> {

    @Query(value = "select * from time_logs gets where date(gets.created_at) = :date and gets.user_id_fk = :user_id_fk", nativeQuery = true)
    List<TimeLogs> findAllByCreatedAtDate(int date, int user_id_fk);

    @Query(value = "select * from time_logs gets where date(gets.created_at) = :strDate and gets.user_id_fk = :id and gets.is_logged=:isLogged", nativeQuery = true)
    TimeLogs findByCreatedAtAndUserIdFkAndIsLogged(String strDate, Long id, int isLogged);

/*    @Query(value = "select * from time_logs gets where gets.user_id_fk = :id and date(gets.created_at) = :meYesterday ", nativeQuery = true)
    List<TimeLogs> findByUserId(Long id, Date meYesterday);*/
}
