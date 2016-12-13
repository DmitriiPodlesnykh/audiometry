package com.vsu.amm.medframe.service;


import com.vsu.amm.medframe.entity.TestPoint;

public interface TestPointService {
    TestPoint create(TestPoint testPoint);
    TestPoint getOne(Long id);
}
