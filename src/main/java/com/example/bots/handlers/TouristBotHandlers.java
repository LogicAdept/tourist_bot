package com.example.bots.handlers;

import com.example.bots.config.TouristBotProperties;
import com.example.bots.entity.City;
import com.example.bots.service.ICityService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Configuration
@EnableConfigurationProperties({
        TouristBotProperties.class
})
@Component
public class TouristBotHandlers extends TelegramLongPollingBot {

    TouristBotProperties properties;
    ICityService service;

    public TouristBotHandlers(TouristBotProperties properties, ICityService service) {
        this.properties = properties;
        this.service = service;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String request = update.getMessage().getText();
            String response;

            long chat_id = update.getMessage().getChatId();

            switch (request) {
                case ("/start"):
                    response = "Добро пожаловать, введите название города который хотите посетить или /help для получения списка комманд";
                    break;
                case ("/help"):
                    response = "Данный бот предоставляет краткую информацию о городе";
                    break;
                case ("/cities"):
                    response = service.getAll().stream().map(City::getName).collect(Collectors.joining("\n"));
                    break;
                default:
                    City city = service.getByName(request);
                    response = city != null ? city.getDescription() : "Такого города нет в базе данных";
                    break;
            }
            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
            List<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow row = new KeyboardRow();

            row.add("/help");
            row.add("/cities");
            keyboard.add(row);
            keyboardMarkup.setKeyboard(keyboard);

            SendMessage message = new SendMessage()
                    .setChatId(chat_id)
                    .setText(response)
                    .setReplyMarkup(keyboardMarkup);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return properties.getUsername();
    }

    @Override
    public String getBotToken() {
        return properties.getToken();
    }

}
