package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.entity.Test;

public interface TestService {

    Test addTest(Test test);

    Test saveTest(Test test);

    Test editTest(Test test);

    Test getById(Long id);

    void deleteTest(Test test);
}
