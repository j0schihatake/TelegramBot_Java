package j0schi.bot.service;

import j0schi.bot.telegram.Bot;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class BotService {

    private final String BOT_NAME = "j0schiBot";
    private final String BOT_TOKEN = "5218967345:AAHI_-PObZ4xx8Jx3kcH1eN9pVluZ9c34e4";

    //------------------------------ Main thread
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws SQLException, ClassNotFoundException {
        System.out.println("Start main code.");
        start();
    }

    public void start(){
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot(BOT_NAME, BOT_TOKEN));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
