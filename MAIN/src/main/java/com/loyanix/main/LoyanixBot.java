package com.loyanix.main;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Date;

public class LoyanixBot extends TelegramLongPollingBot {

    private void sendMessage(Long chatId, String messageToSend){
        SendMessage sendMessage = new SendMessage().setChatId(chatId).setText(messageToSend);
        try{
            execute(sendMessage);
        }
        catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {

        if(update.hasMessage() && update.getMessage().hasText()){
            String message = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            String messageToSend;
            if (message.equals("/time")){
                messageToSend = new Date().toLocaleString();
            }else {
                messageToSend = message;
            }
            sendMessage(chatId, messageToSend);
        }
    }

    public String getBotUsername() {
        return "loyanix_bot";
    }

    public String getBotToken() {
        return "673599881:AAEEw8AbNd6s6O8JHOBtTtoN80ZkRJ0F1Ic";
    }
}
