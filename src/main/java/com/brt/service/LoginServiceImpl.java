package com.brt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor=Throwable.class)
public class LoginServiceImpl implements LoginService {

}
