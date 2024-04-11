package ru.gb.example3_sem3_hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;

@Service
public class RegistrationService {

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    //Поля UserService, NotificationService
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;


    //Метод processRegistration
    public void processRegistration(String name, int age, String mail){
        User user = userService.createUser(name, age, mail);
        dataProcessingService.addUserToList(user);
        notificationService.sendNotification("Добавлен пользователь" + user);
    }
}
