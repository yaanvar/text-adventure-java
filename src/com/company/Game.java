package com.company;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    HashMap<String, Situation> situations = new HashMap<>();
    Player sasha = new Player("Саша", 100);
    Enemy x = new Enemy("Рэйдер", 100);
    boolean key = false;

    Game() {

        Situation temp = new Situation();
        temp.description = "Санкт-Петербург и сосиски.\n\nДень шел своим чередом, но я все надеялся найти сосиски на полках магазинов\n"
                + "Санкт-Петербурга. Я как раз таки стоял перед последним магазином, который еще не был посещен.\n"
                + "Гастроном 24 часа \"У дяди Антона\". У этого магазина была не лучшая репутация, но вся надежда на него.\n"
                + "1 - Зайти внутрь магазина\n" + "2 - Лучше я останусь без сосисок, чем зайду туда";
        temp.name = "start";
        temp.ways.add("magazin");
        temp.ways.add("shawerma");
        situations.put(temp.name, temp);

        temp = new Situation();
        temp.description = "Я вошел внутрь, магазин оказался неплохим, но в 47 году не соблюдать правила профсоюзов?\n"
                + "Да и уже неважно, главное найти сосиски, а то будет плохо, если Сережик до меня доберется,\n"
                + "а у меня не будет сосисок, чтобы откупиться, благо туалетную бумагу я выбил в ашане с усилием.\n"
                + "Ты кто такой? - спросил меня мужчина за прилавком, вероятно он был дядя Антон,\n"
                + "у меня по спине пробежались мурашки, да и само Купчино такой себе район, довольно криминогенный.\n"
                + "Я Саша, Александр Черепашкин - робко ответил я.\n"
                + "Мне нужны сосиски, прошу вас или Сережик голову мне снесет.\n"
                + "Вечно вы собаки между собой грызетесь, то за аугментации, то за что-то еще, теперь уж за сосиски.\n"
                + "Ладно, Малой, не боись завалялось у меня коробка в кладовку, тащи сам, у меня уже спина не та, а\n"
                + "империалы переведешь потом.\n"
                + "1 - Войти в кладовку\n" + "2 - Вежливо отказаться, и пойти на улицу\n" + "3 - Купить у дяди Антона что-нибудь";
        temp.name = "magazin";
        temp.ways.add("sklad");
        temp.ways.add("shawerma");
        temp.ways.add("prilavok");
        situations.put(temp.name, temp);

        temp = new Situation();
        temp.description = "У вас есть что-нибудь от насекомых, что-нибудь для защиты? - спросил я\n"
                + "Да, найдется, тебе аугментатор нужен или аптечка? - ответил дядя Антон\n"
                + "У вас есть аугментатор для такого типа машин?- я опрокинул кисть назад и показал моторчик внутри руки\n"
                + "Недавно такие привезли, тебе повезло, но парень, империалы для таких дел сейчас не в ходу, так что кинешь коинами?\n"
                + "Я вчера намайнил сдесяток, хватит?\n"
                + "Думаю да, бери что желаешь. Он достал из под прилавка два аугментатора и две аптечки.\n"
                + "1 - Взять две аптечки\n2 - Взять два аугментатора\n3 - Взять аугментатор и аптечку";
        temp.name = "prilavok";
        temp.ways.add("1");
        temp.ways.add("2");
        temp.ways.add("3");
        situations.put(temp.name, temp);

        temp = new Situation();
        temp.description = "Я решил все же взять из кладовки сосиски, да и взгляд у этого мужичка вызывал доверие, что ли, да и впрочем неважно.\n"
                + "Сейчас главное скорее найти эту коробку и бежать, что есть силы, пока рейдеры не вышли на охоту.\n"
                + "Купчино - место опасное, именно тут начали распространять технологии военных, теперь тут у каждого\n"
                + "ствол в руке или клинок в ладони. За купчинцами оно распространилось по всему мегаполису. Банд стало\n"
                + "слишком много, что кланы захватили Санкт-Петербург, и он вышел из Европейского Альянса, но Москва\n"
                + "все еще пытается отвоевать Петербург, но все бестолку, воевать против анархистов сложно.\n"
                + "А кто знает, может кланы уже выкупили Московских чиновников, и те больше не будут нападать?\n"
                + "Денег у них достаточно, они же владеют доком мирового даркнета.\n\n"
                + "В темноте я нашел коробку, с трудом выбрался из кладовки, и, не позабыв поблагодарить дядю Антона,\n"
                + "вышел на улицу.\n"
                + "1 - Побежать домой, что есть мочи\n" + "2 - Пойти к приятелю";
        temp.name = "sklad";
        temp.ways.add("battle");
        temp.ways.add("shawerma");
        situations.put(temp.name, temp);

        temp = new Situation();
        temp.description = "Ночь была темная, и я бежал так быстро, как мог. За углом слышен чей-то топот. Нужно что-то делать\n"
                +          "1 - Активировать клинки\n" + "2 - Разогнуть кисть, чтобы подготовить ствол"; //реализовать бафф за подготовку
        temp.name = "battle";
        temp.ways.add("death");
        temp.ways.add("shawerma");
        situations.put(temp.name, temp);

        temp = new Situation();
        temp.description = "Я все же решил пойти в к другу в его шаверма-ресторан \"Мяу-муя\" там всегда безопасно.\n"
                + "На поребрике какой-то чувак ел шаверму, какие-то мутные штришки зашли в темную парадную.\n"
                + "Не успел я дойти до ресторана, как ко мне подьехала машина красного цвета.\n"
                + "Из окна выглянул Сережик, выкинул хабарик(окурок), он был в багровом бодлоне(водолазке) и грозно смотрел на меня.\n"
                + "Что несешь в своей сумке, Санёк? - сказал он фамильярно.\n"
                + "Надеюсь, те 10 пачек молочных сосисок и три руллона туалетной бумаги, что ты мне задолжал.\n"
                + "Мне подсознательно хотелось бежать, я будто провалился сквозь землю, но он резко выхватил мою сумку и осмотрел содержимое.\n"
                + "Он резко выпячил ствол из кисти...\n"
                + "1 - Готовиться бежать\n" + "2 - Ничего не делать";
        temp.name = "shawerma";
        temp.ways.add("death");
        temp.ways.add("victory");
        situations.put(temp.name, temp);

        temp = new Situation();
        temp.description = "Ха. Испугался? Молоток, тут даже больше, чем надо, с тобой приятно иметь дело, а теперь топай, да побыстрей - сказал Сережик и уехал\nКонец\n";
        temp.name = "victory";
        situations.put(temp.name, temp);

        temp = new Situation();
        temp.description = "Вас застрели ночью, вовсе не темной...\nКонец\n";
        temp.name = "death";
        situations.put(temp.name, temp);

    }

    void battle(Player a, Enemy x) {
        Scanner in = new Scanner(System.in);
        System.out.println("Гоп-стоп! Он подошел из за угла...\nНа вас напал " + x.name);
        while (a.health > 0 && x.health > 0) {
            System.out.println("\nВаш ход\n1 - стрелять из пистолета\n2 - достать нож\n3 - посмотреть инвентарь");
            int r = in.nextInt();
            while (r < 1||r > 3) r = in.nextInt();
            if (r == 1) {
                System.out.println("HP врага = " + x.health);
                a.attack_gun(x);
                System.out.println("HP врага = " + x.health);
            }
            if (r == 2) {
                System.out.println("HP врага = " + x.health);
                a.attack_knife(x);
                System.out.println("HP врага = " + x.health);
            }
            if (r == 3) {
                a.use(a);
            }
            System.out.println("\nХод врага");
            System.out.println("Ваш HP = " + a.health);
            x.attack_gun(a);
            System.out.println("Ваш HP = " + a.health);
        }
        if (a.health > 0) {
            System.out.println("Битва завершена. Вы победили!");
            if(a.health % 2 == 0) {
                a.get_thing(a, "Аптечка");
            }
            if(a.health % 2 == 1) {
                a.get_thing(a, "Аугментатор");
            }
        }
        else a.alive = false;
    }

    void start() {
        Scanner in = new Scanner(System.in);
        Situation currentSituation = (Situation) this.situations.get("start");
        do {
            System.out.println(currentSituation.description);
            int way;
            do {
                way = in.nextInt();
            } while (way < 1 || way > currentSituation.ways.size());
            if (currentSituation.name == "battle") {
                battle(sasha, x);
                if (sasha.alive == true) {
                    currentSituation = situations.get("shawerma");
                } else {
                    currentSituation = situations.get("death");
                }
            } else if(currentSituation.name == "prilavok"){
                if(way == 1){
                    sasha.get_thing(sasha, "Аптечка");
                    sasha.get_thing(sasha, "Аптечка");
                }
                if(way == 2){
                    sasha.get_thing(sasha, "Аугментатор");
                    sasha.get_thing(sasha, "Аугментатор");
                }
                if(way == 3){
                    sasha.get_thing(sasha, "Аугментатор");
                    sasha.get_thing(sasha, "Аптечка");
                }
                currentSituation = situations.get("sklad");
            } else if(currentSituation.name == "shawerma"&&key == true){
                currentSituation = situations.get("victory");
            } else if(currentSituation.name == "shawerma"&&key == false) {
                currentSituation = situations.get("death");
            } else {
                if (currentSituation.name == "sklad") {
                    key = true;
                }
                currentSituation = (Situation) this.situations.get(currentSituation.ways.get(way - 1));
            }
        } while (currentSituation.ways.size() != 0);

        System.out.println(currentSituation.description);
    }
}
