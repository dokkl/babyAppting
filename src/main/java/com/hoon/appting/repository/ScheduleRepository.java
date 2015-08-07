package com.hoon.appting.repository;

import com.hoon.appting.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hoon on 2015-07-22.
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
