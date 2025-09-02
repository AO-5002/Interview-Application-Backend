package org.example.interviewprojectserver.services;

import io.getstream.chat.java.models.User;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class StreamTokenService {

    public String generateStreamToken(String userId) {
        return User.createToken(userId, null, null);
    }

    public String generateTokenWithExpiration(String userId){
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.HOUR, 1);
        return User.createToken(userId, calendar.getTime(), null);
    }

}
