package edu.mum.cs.swe425.project.serviceImpl;
import edu.mum.cs.swe425.project.domain.BusinessDay;
import edu.mum.cs.swe425.project.domain.Seat;
import edu.mum.cs.swe425.project.domain.ServiceTime;
import edu.mum.cs.swe425.project.repository.BusinessDayRepository;
import edu.mum.cs.swe425.project.repository.SeatRepository;
import edu.mum.cs.swe425.project.repository.ServiceTimeRepository;
import edu.mum.cs.swe425.project.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImplementation implements AppointmentService {
    private BusinessDayRepository businessDayRepository;
    private SeatRepository seatRepository;
    private ServiceTimeRepository serviceTimeRepository;

    public AppointmentServiceImplementation(BusinessDayRepository businessDayRepository, SeatRepository seatRepository, ServiceTimeRepository serviceTimeRepository) {
        this.businessDayRepository = businessDayRepository;
        this.seatRepository = seatRepository;
        this.serviceTimeRepository = serviceTimeRepository;
    }

    @Override
    public void saveBusinessDay(BusinessDay businessDay) {
        businessDayRepository.save(businessDay);
    }

    @Override
    public void saveServiceTime(ServiceTime serviceTime) {
        serviceTimeRepository.save(serviceTime);
    }

    @Override
    public void saveSeat(Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    public boolean defaultBusinessDaysExist() {
        return businessDayRepository.count() > 0;
    }

    @Override
    public boolean defaultSeatsExist() {
        return seatRepository.count() > 0;
    }

    @Override
    public boolean defaultServiceTimesExist() {
        return serviceTimeRepository.count() > 0;
    }

}
