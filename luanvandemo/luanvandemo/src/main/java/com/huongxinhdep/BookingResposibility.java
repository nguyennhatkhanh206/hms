package com.huongxinhdep;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
public interface BookingResposibility extends JpaRepository<Booking, Integer>{
List <Booking> findByPricePerNightLessThan(double price);
}
