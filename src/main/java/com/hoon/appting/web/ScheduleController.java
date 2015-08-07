package com.hoon.appting.web;

import com.hoon.appting.entity.QSosi;
import com.hoon.appting.entity.Schedule;
import com.hoon.appting.entity.Sosi;
import com.hoon.appting.repository.ScheduleRepository;
import com.hoon.appting.repository.SosiRepository;
import com.mysema.query.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hoon on 2015-07-22.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private SosiRepository sosiRepository;

    @RequestMapping("{scheduleId}")
    public Schedule getSchedule(@PathVariable Long scheduleId) {
        Schedule schedule = scheduleRepository.findOne(scheduleId);
        Sosi sosi = schedule.getSosi();
        return schedule;
    }

    @RequestMapping("add/{sosiId}")
    public Schedule addSchedule(@PathVariable Long sosiId, @RequestParam(value="program") String program) {
        Sosi sosi = sosiRepository.findOne(sosiId);
        Schedule schedule = scheduleRepository.save(new Schedule(sosi, program));

        return schedule;
    }

    @RequestMapping("dsltest")
    public String test() {
        QSosi qSosi = QSosi.sosi;
        Predicate predicate = qSosi.name.like("티" + "%").or(qSosi.id.eq(Long.valueOf(3)));
        Iterable<Sosi> list = sosiRepository.findAll(predicate);
        for (Sosi sosi : list) {
            System.out.println("name : " + sosi.getName());
        }
        return "test";
    }
}
