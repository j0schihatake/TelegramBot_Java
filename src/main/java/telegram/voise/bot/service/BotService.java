package telegram.voise.bot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class BotService {

    //------------------------------ Main thread
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws SQLException, ClassNotFoundException {
        System.out.println("Start main code.");
    }
}
