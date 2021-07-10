package com.sprayou.spray.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sprayou.spray.dto.HelloDto;

public interface HelloDao extends JpaRepository <HelloDto, Integer> {

}
