package edu.mum.cs.swe425.project.service;

import edu.mum.cs.swe425.project.domain.BusinessDay;
import edu.mum.cs.swe425.project.domain.Seat;
import edu.mum.cs.swe425.project.domain.ServiceTime;

public interface AppointmentService {
    public void saveBusinessDay(BusinessDay businessDay);

    public void saveServiceTime(ServiceTime serviceTime);

    public void saveSeat(Seat seat);

    public boolean defaultBusinessDaysExist();

    public boolean defaultSeatsExist();

    public boolean defaultServiceTimesExist();

}
