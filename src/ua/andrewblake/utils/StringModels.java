package ua.andrewblake.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StringModels {

    //Date & Time:
    private static String[] years = {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"};
    private static String[] months = {"Січень", "Лютий", "Березень", "Квітень", "Травень", "Червень", "Липень", "Серпень", "Вересень", "Жовтень", "Листопад", "Грудень"};
    private static String[] days_31 = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private static String[] hours = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    private static String[] minutes = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59",};

    //Different:
    private static String[] shch = {"  -", "ШЧ-1", "ШЧ-2", "ШЧ-3", "ШЧ-4", "ШЧ-5", "ШЧ-6", "ШЧ-8", "ШЧ-9", "ШЧ-10", "ШЧ-11", "ШЧ-12"};
    private static String[] stationOrPeregon = {"      -", "Станція", "Перегін"};
    private static String[] typesOfDevices = {" -", "ЕЦ", "КлЗ", "АБ", "РПБ", "ПС", "ГАЦ", "ДЦ", "ЧДК", "АДЦУ", "АЛСН", "Інші"};
    private static String[] typicalReasonForEC = {"-", "Не працює ЕЦ", "Несправжня зайнятість", "Несправжня вільність", "Перекрився сигнал", "Не відкривається сигнал", "Неможливо задати маршрут", "Неможливо розробити маршрут", "Не переводиться стрілка", "Стрілка втратила контроль положення", "Неможливість аварійного переводу стрілки", "Неможливість переключення контактної мережі", "Вихід з ладу акумуляторної батареї"};
    private static String[] typicalReasonForKlZ = {"-", "Несправжня зайнятість", "Несправжня вільність", "Перекрився сигнал", "Не відкривається сигнал", "Нема контролю маршруту горловини", "Не переводиться стрілка", "Розряд станційної батареї", "Розряд батареї горловини", "Неможливість аварійного відкриття сигналу", "Не спрацювала схема фіксації прибуття"};
    private static String[] typicalReasonForAB = {"-", "На прохідному світлофорі горить червоний вогонь", "На прохідному світлофорі горить більш-дозволяючий вогонь", "Несправжня зайнятість блок-дільниці", "Погашені вогні прохідного світлофора", "Перекрився прохідний світлофор", "Неможливо змінити напрям", "Розламався перегон", "Відсутність живлення", "Несправжня зайнятість перегону по лінії сповіщення"};
    private static String[] typicalReasonForNAB = {"-", "Не проходить блок-сигнал \"Даю згоду\" (ДС)", "Не пройшов блок-сигнал прибуття поїзда (ПП)", "Не спрацювала схема фіксації прибуття поїзда", "Не працює схема штучного прибуття поїзда", "Несправжня зайнятість дільниці наближення"};
    private static String[] typicalReasonForPS = {"-", "Не подається сповіщення", "Постійно працює автосигналізація", "Не закривається шлагбаум", "Не відкривається шлагбаум", "Не вмикається загороджуючий сигнал", "Не вимикається загороджуючий сигнал", "Довільне включення загороджуючого сигналу", "Не горить дорожній світлофор", "Не працює дзвінок дорожнього світлофора", "Не працює схема дистанційного контролю переїзду", "Не горять вогні переїздного світлофора"};
    private static String[] typicalReasonForGAC = {"-", "Неможливий автоматичний розпуск вагонів", "Неможливо встановити маршрут", "Не переводиться стрілка", "Відсутність контролю положення стрілки", "Несправжня зайнятість секції", "Несправність сповільнювача", "Не працює пневмопошта", "Відсутність живлення"};
    private static String[] typicalReasonForDC = {"-", "Невірна інформація на пульт-табло", "Не проходять сигнали", "Неможливо встановити маршрут", "Неможливо відкрити сигнал", "Неможливо передати станцію на резервне управління", "Пошкодження", "Загорівся контроль аварії"};
    private static String[] departments = {"-", "Ш", "П", "Д", "Е", "Інша"};
    private static String[] listPCh = {"-", "ПЧ-1", "ПЧ-2", "ПЧ-3", "ПЧ-4", "ПЧ-5", "ПЧ-6", "ПЧ-7", "ПЧ-8", "ПЧ-9", "ПЧ-10", "ПЧ-11", "ПЧ-12", "ПЧ-13", "ПЧ-14", "ПЧ-15", "ПЧ-16", "ПЧ-17", "ПЧ-18", "ПЧ-19"};

    // Objects:
    private static String[] shObjects = {"-", "Пульти, табло, апарати управління", "Шафи, стативи, коробки, ящики", "Щитові електропостач. установки", "Акумулятори", "Сигнали", "Приводи, замки", "Повітряні лінії", "Кабельні лінії", "Рейкові кола", "Інші об'єкти"};
    private static String[] shObjects2ForShObjects_1 = {"-", "Пульт-маніпулятор ЕЦ", "Виносне табло ЕЦ", "Пульт-табло РЦ МРЦ", "Пульт-маніпулятор ДЦ", "Виносне табло ДЦ", "Уніфікований пульт", "Пульт для гірок ПГУ-65", "Шафа штучної розробки маршрутів", "Маневрова колонка №", "Пульт маневрової вишки", "Пульт статив ПАБ", "Стрілочний централізатор", "МКУ системи Наталевича", "Електрожезловий апарат", "Щиток управління ПС", "Щиток управління ТС"};
    private static String[] shObjects2ForShObjects_2 = {"-", "Релейна шафа", "Статив", "Коробка", "Інші об'єкти"};
    private static String[] shObjects2ForShObjects_3 = {"-", "Щиток вимикання живлення ЩВП-73", "Ввідна панель", "Ввідно-розподільна панель ПВР-40", "Панель релейна", "Панель розподільчо-перетворююча ПРП-ЕЦ", "Розподільча панель ПР-ЕЦ25", "Панель перетворювачів ПП50-ЕЦ", "Панель випрамлячів", "Статив перетворювачів СП1-50/25", "Панель конденсаторів ПК1", "Інша панель"};
    private static String[] shObjects2ForShObjects_4 = {"-", "Акумулятор АБН-72", "Акумулятор АБН-80", "Акумулятор С-", "Акумулятор СК-", "Акумулятор САП", "Інший акумулятор"};
    private static String[] shObjects2ForShObjects_5 = {"-", "Світлофор поїзний", "Маршрутний покажчик", "Покажчик напряму", "Світлофор переїздний"};
    private static String[] shObjects2ForShObjects_6 = {"-", "Електропривід", "Замок Мелентьєва", "Приводозамикач", "Інший"};
    private static String[] shObjects2ForShObjects_7 = {"-", "Сигнальна", "Кодова"};
    private static String[] shObjects2ForShObjects_8 = {"-", "Кабель магістральний", "Кабель сигнальний", "Кабель силовий", "Кабель стрілочний"};

    // Elements:
    private static String[] shElementsForShObjects_1 = {"-", "Кнопка", "Комутатор", "Монтаж", "З'єднання", "Лампочка індикації", "Електрозамикач ключа-жезла", "Блок-механізм", "Індуктор", "Апаратний замок", "Лічильник", "Амперметр"};
    private static String[] shElementsForShObjects_2 = {"-", "Релейна апаратура", "Безконтактна апаратура", "Трансформатори", "Елементи захисту", "Інші елементи"};
    private static String[] shElementsForShObjects_3 = {"-", "Релейна апаратура", "Безконтактна апаратура", "Трансформатори", "Елементи захисту", "Інші елементи"};
    private static String[] shElementsForShObjects_4 = {"-", "Пластина", "Клема", "Електроліт", "Сепаратор"};
    private static String[] shElementsForShObjects_5 = {"-", "Мачта", "Фундамент", "Стакан", "Світлофорна головка", "Лінзовий комплект", "Лампотримач", "Лампочка", "Кабельна муфта", "Монтаж (джгут)"};
    private static String[] shElementsForShObjects_6 = {"-", "Автоперемикач", "Робочий шибер", "Механічна передача", "Блок-контакти", "Монтаж", "Електродвигун", "Замок Мелентьєва", "Курбельна заслінка", "Інший елемент"};
    private static String[] shElementsForShObjects_7 = {"-", "Провід", "Опора"};
    private static String[] shElementsForShObjects_8 = {"-", "Жили", "Муфта"};
    private static String[] shElementsForShObjects_9 = {"-", "Релейна апаратура", "Безконтактна апаратура", "Трансформатори", "Елементи захисту", "Рейкові з'єднувачі", "Інші елементи"};
    private static String[] relayEquipment = {"-", "Реле", "Блок", "Дешифратор", "Трансміттер", "Сигнальний механізм"};
    private static String[] objectsContactlessDevices = {"-", "Безконтактне реле", "Безконтактний трансміттер", "Блок конденсаторний", "Блок витримки часу", "Конденсатор", "Випрамляч", "Випрамляючий елемент", "Перетворювач", "Блок захисний", "Фазуючий пристрій", "Апаратура", "Резистор", "Апаратура АЛСН", "Блок фазний"};
    private static String[] condensingUnits = {"КБМШ", "БКСМШ", "КБ", "КБД", "БК-ДА", "БКР", "Інший"};
    private static String[] rectifiers = {"-", "ВАК", "ВУС-1,3", "БПШ", "БП-3", "БПСН", "УППС", "БВС", "ЗБУ-12/20", "РТА", "Інший"};
    private static String[] transformers = {"-", "ППШ-3", "ПЧ-50/25", "ППВ-1", "ППС-1", "ППС-1,7", "ПП-300М", "ППВ-0,5М", "ДБ ППВ-0,5", "ПО-550АФ", "Інший"};
    private static String[] protectiveUnits = {"-", "ЗБФ-1М", "РЗФ-2", "РЗФШ-2", "ЗБ-3", "ЗБ-ДСШ", "Інший"};
    private static String[] securityFeatures = {"-", "Запобіжник", "Вимикач автоматичний АВМ", "Фільтр колійний ФП-25", "Розрядник", "Вирівнювач", "Варистор", "Заземлення"};
    private static String[] otherElementsStative = {"-", "Штепсельна плата", "Знімна плата", "Монтаж", "Клема", "Клемна колодка", "Шина", "Інші"};
    private static String[] otherElementsElectricitySupplyInstallations = {"-", "Кнопка",  "Тумблер-вимикач", "Пакетний вимикач", "Контактор", "Автоматичний вимикач", "Магнітний пускач", "Дросель насичення", "Перетворювач", "Реле контролю напруги", "Автоматичний зарядний пристрій", "Блок автоматичного регулювання", "Блок фазний", "Лічильник числа відключень", "Сигналізатор заземлення", "Вимірювальний прилад", "Випрамляючий елемент", "Монтаж"};
    private static String[] otherElementsRackAndPinionRange = {"-",  "Перемичка", "Стрілочна гарнітура", "Дросель-трансформатор", "Інший елемент"};

    // Element-2:
    private static String[] relayEquipmentForElement2 = {"-", "Обмотка", "Монтаж", "Контакти", "Передаюча система", "Випрямляючий елемент", "Конденсатор", "Резистор", "Інший елемент"};
    private static String[] objectsContactlessDevicesForElement2 = {"-", "Обмотка", "Монтаж", "Контакти", "Передаюча система", "Випрямляючий елемент", "Конденсатор", "Резистор", "Інший елемент"};
    private static String[] transformersForElement2 = {"-", "Обмотка", "Монтаж", "Контакти", "Передаюча система", "Випрямляючий елемент", "Конденсатор", "Резистор", "Інший елемент"};
    private static String[] securityFeaturesForElement2 = {"-", "Плавка вставка", "Ніжка", "Клема", "Цоколь", "Вентельний диск", "Термоелемент", "Іскровий проміжок", "Корпус"};

    // Reason-1:
    private static String[] shReasons1ForShObjects_1 = {"-", "Втрата контакту", "Підгоріли контакти", "Обрив монтажного проводу", "Закорочування", "Перегоріла нитка накалювання", "Механічне пошкодження"};
    private static String[] reasonForRelayEquipment = {"-", "Коротке замикання", "Обрив", "Пробій", "Втрата контакту", "Втрата ємності", "Гроза", "Інше"};
    private static String[] reasonForObjectsContactlessDevices = {"-", "Коротке замикання", "Обрив", "Пробій", "Втрата контакту", "Втрата ємності", "Гроза", "Інше"};
    private static String[] reasonForTransformers = {"-", "Обрив", "Замикання", "Втрата контакту", "Зниження ізоляції за рахунок", "Загоряння ізоляції", "Невідповідність коефіцієнта трансформації", "Механічне пошкодження"};
    private static String[] reasonForSecurityFeatures = {"-", "Невідповідність номіналу струмному навантаженню", "Коротке замикання", "Діаметр проводу не відповідає номіналу", "Неякісна пайка", "Старіння і окислення", "Неправильне регулювання сигнальної пружини", "Дефект матеріалу", "Втрата контакту", "Гроза", "Тяговий струм", "Механічне пошкодження", "Причина не встановлена"};
    private static String[] reasonForOtherElementsStative = {"-", "Монтажний провід", "Сполучення монтажних проводів", "Втрата контакту", "Зламалась вісь кріплення"};
    private static String[] reasonForOtherElementsElectricitySupplyInstallations = {"-", "Втрата контакту", "Обрив монтажного проводу", "Плавка вставка", "Зламалась контактна пластина", "Невідповідність струмному навантаження", "К.З. під час виконання робіт", "Гроза", "Заводський брак"};
    private static String[] reasonForOtherElementsRackAndPinionRange = {"-", "Відсутність", "Обрив", "Втрата контакту", "Згорання", "Пробій", "Закорочування перемичок одна на одну", "Вихід з ладу дросель-трансфоматора", "Вихід з ладу обмотки", "Причина не встановлена", "Інша причина"};
    private static String[] shReasons1ForShObjects_4 = {"-", "Сульфатація", "Переполюсація", "Внутрішнє коротке замикання", "Саморозряд", "Неякісний електроліт", "Руйнування", "Втрата контакту", "Обрив виводу", "Розряд"};
    private static String[] shReasons1ForShObjects_5 = {"-", "Втрата контакту в лампотримачі", "Обрив", "Заниження ізоляції", "Сполучення проводів", "Перегорання лампи", "Падіння світлофора - корозія", "Руйнування фундаменту", "Бій лінзового комплекту", "Інша причина"};
    private static String[] shReasons1ForShObjects_6 = {"-", "Втрата контакту", "Недостатнє врубання ножів", "Підгоріли контакти", "Механічне пошкодження", "Забруднення контактів", "Обледеніння", "Заклинювання", "Послаблення фрикції", "Затягнута фрикція", "Обрив", "Електродвигун", "Фізичне старіння", "Пошкодження монтажу", "Розтягнута пружина", "Розрегулювання", "Злом", "Викрошування підшипника", "Інше"};
    private static String[] shReasons1ForShObjects_7 = {"-", "Обрив", "Сполучення (к.з.)", "Накид", "Кліматичні впливи"};
    private static String[] shReasons1ForShObjects_8 = {"-", "Обрив", "Зовнішні впливи - тяговий і блукаючий струми", "Заниження ізоляції", "Сполучення (к.з.)"};

    // Reason-2:
    private static String[] shReasons2 = {"-", "Конструктивні", "Експлуатаційні"};
    private static String[] shReasons2OperationalReasons = {"-", "Порушення терміну виконання робіт згідно інструкції ЦШ-4616", "Порушення технології виконання робіт згідно інструкції ЦШ-4616", "Порушення правил безпеки руху згідно інструкції ЦШ-4397", "Помилка під час виконання робіт, що не викликала порушення безпеки руху", "Неякісна перевірка і ремонт в КВП, майстернях та інш.", "Старіння, зношеність", "Гроза, стихія, перенапруга", "Причина не встановлена"};

    // MySQL Date:
    private static String[] allStations;
    private static String[] shch1Stations;
    private static String[] shch2Stations;
    private static String[] shch3Stations;
    private static String[] shch4Stations;
    private static String[] shch5Stations;
    private static String[] shch6Stations;
    private static String[] shch8Stations;
    private static String[] shch9Stations;
    private static String[] shch10Stations;
    private static String[] shch11Stations;
    private static String[] shch12Stations;
    private static String[] allPeregons;
    private static String[] shch1Peregons;
    private static String[] shch2Peregons;
    private static String[] shch3Peregons;
    private static String[] shch4Peregons;
    private static String[] shch5Peregons;
    private static String[] shch6Peregons;
    private static String[] shch8Peregons;
    private static String[] shch9Peregons;
    private static String[] shch10Peregons;
    private static String[] shch11Peregons;
    private static String[] shch12Peregons;




    //||\\********** Methods:

    //Date & Time:
    public static String[] getYears() {
        return years;
    }

    public static String[] getMonths() {
        return months;
    }

    public static String[] getDays_31() {
        return days_31;
    }

    public static String[] getHours() {
        return hours;
    }

    public static String[] getMinutes() {
        return minutes;
    }

    //Different:
    public static String[] getShch() {
        return shch;
    }

    public static String[] getStationOrPeregon() {
        return stationOrPeregon;
    }

    public static String[] getTypesOfDevices() {
        return typesOfDevices;
    }

    public static String[] getTypicalReasonForEC() {
        return typicalReasonForEC;
    }

    public static String[] getTypicalReasonForKlZ() {
        return typicalReasonForKlZ;
    }

    public static String[] getTypicalReasonForAB() {
        return typicalReasonForAB;
    }

    public static String[] getTypicalReasonForNAB() {
        return typicalReasonForNAB;
    }

    public static String[] getTypicalReasonForPS() {
        return typicalReasonForPS;
    }

    public static String[] getTypicalReasonForGAC() {
        return typicalReasonForGAC;
    }

    public static String[] getTypicalReasonForDC() {
        return typicalReasonForDC;
    }

    public static String[] getDepartments() {
        return departments;
    }

    public static String[] getListPCh() {
        return listPCh;
    }

    // MySQL Date:
    public static void resetStations() {
        shch1Stations = null;
        shch2Stations = null;
        shch3Stations = null;
        shch4Stations = null;
        shch5Stations = null;
        shch6Stations = null;
        shch8Stations = null;
        shch9Stations = null;
        shch10Stations = null;
        shch11Stations = null;
        shch12Stations = null;
    }

    public static String[] getShch1Stations() {
        if (shch1Stations != null) { return shch1Stations; }
        shch1Stations = getFromDB("stations", 1);
        return shch1Stations;
    }

    public static String[] getShch2Stations() {
        if (shch2Stations != null) { return shch2Stations; }
        shch2Stations = getFromDB("stations", 2);
        return shch2Stations;
    }

    public static String[] getShch3Stations() {
        if (shch3Stations != null) { return shch3Stations; }
        shch3Stations = getFromDB("stations", 3);
        return shch3Stations;
    }

    public static String[] getShch4Stations() {
        if (shch4Stations != null) { return shch4Stations; }
        shch4Stations = getFromDB("stations", 4);
        return shch4Stations;
    }

    public static String[] getShch5Stations() {
        if (shch5Stations != null) { return shch5Stations; }
        shch5Stations = getFromDB("stations", 5);
        return shch5Stations;
    }

    public static String[] getShch6Stations() {
        if (shch6Stations != null) { return shch6Stations; }
        shch6Stations = getFromDB("stations", 6);
        return shch6Stations;
    }

    public static String[] getShch8Stations() {
        if (shch8Stations != null) { return shch8Stations; }
        shch8Stations = getFromDB("stations", 8);
        return shch8Stations;
    }

    public static String[] getShch9Stations() {
        if (shch9Stations != null) { return shch9Stations; }
        shch9Stations = getFromDB("stations", 9);
        return shch9Stations;
    }

    public static String[] getShch10Stations() {
        if (shch10Stations != null) { return shch10Stations; }
        shch10Stations = getFromDB("stations", 10);
        return shch10Stations;
    }

    public static String[] getShch11Stations() {
        if (shch11Stations != null) { return shch11Stations; }
        shch11Stations = getFromDB("stations", 11);
        return shch11Stations;
    }

    public static String[] getShch12Stations() {
        if (shch12Stations != null) { return shch12Stations; }
        shch12Stations = getFromDB("stations", 12);
        return shch12Stations;
    }

    public static void resetPeregons() {
        shch1Peregons = null;
        shch2Peregons = null;
        shch3Peregons = null;
        shch4Peregons = null;
        shch5Peregons = null;
        shch6Peregons = null;
        shch8Peregons = null;
        shch9Peregons = null;
        shch10Peregons = null;
        shch11Peregons = null;
        shch12Peregons = null;
    }

    public static String[] getShch1Peregons() {
        if (shch1Peregons != null) { return shch1Peregons; }
        shch1Peregons = getFromDB("peregons", 1);
        return shch1Peregons;
    }

    public static String[] getShch2Peregons() {
        if (shch2Peregons != null) { return shch2Peregons; }
        shch2Peregons = getFromDB("peregons", 2);
        return shch2Peregons;
    }

    public static String[] getShch3Peregons() {
        if (shch3Peregons != null) { return shch3Peregons; }
        shch3Peregons = getFromDB("peregons", 3);
        return shch3Peregons;
    }

    public static String[] getShch4Peregons() {
        if (shch4Peregons != null) { return shch4Peregons; }
        shch4Peregons = getFromDB("peregons", 4);
        return shch4Peregons;
    }

    public static String[] getShch5Peregons() {
        if (shch5Peregons != null) { return shch5Peregons; }
        shch5Peregons = getFromDB("peregons", 5);
        return shch5Peregons;
    }

    public static String[] getShch6Peregons() {
        if (shch6Peregons != null) { return shch6Peregons; }
        shch6Peregons = getFromDB("peregons", 6);
        return shch6Peregons;
    }

    public static String[] getShch8Peregons() {
        if (shch8Peregons != null) { return shch8Peregons; }
        shch8Peregons = getFromDB("peregons", 8);
        return shch8Peregons;
    }

    public static String[] getShch9Peregons() {
        if (shch9Peregons != null) { return shch9Peregons; }
        shch9Peregons = getFromDB("peregons", 9);
        return shch9Peregons;
    }

    public static String[] getShch10Peregons() {
        if (shch10Peregons != null) { return shch10Peregons; }
        shch10Peregons = getFromDB("peregons", 10);
        return shch10Peregons;
    }

    public static String[] getShch11Peregons() {
        if (shch11Peregons != null) { return shch11Peregons; }
        shch11Peregons = getFromDB("peregons", 11);
        return shch11Peregons;
    }

    public static String[] getShch12Peregons() {
        if (shch12Peregons != null) { return shch12Peregons; }
        shch12Peregons = getFromDB("peregons", 12);
        return shch12Peregons;
    }

    private static String[] getFromDB(String stationsOrPeregons, int shch) {
        String tempS = "";
        String[] tempArray = new String[0];
        if ((shch >= 1) && (shch <= 6)) {
            tempS = " AND shch = " + shch;
        }
        if ((shch >= 8) && (shch <= 12)) {
            tempS = " AND shch = " + String.valueOf(shch-1);
        }
        try {
            Statement statementForMySQL = ConnectionToMySQL.getStatementForMySQL();
            ResultSet resultSetForMySQL = statementForMySQL.executeQuery("select count(*) from arm_shd_database." + stationsOrPeregons + " where closed = 0" + tempS + ";");
            int count = 0;
            while (resultSetForMySQL.next()) {
                count = resultSetForMySQL.getInt(1);
            }
            tempArray = new String[count];
            resultSetForMySQL = statementForMySQL.executeQuery("select name from arm_shd_database." + stationsOrPeregons + " where closed = 0" + tempS + ";");
            int tempI = 0;
            while (resultSetForMySQL.next()) {
                tempArray[tempI] = resultSetForMySQL.getString(1);
                tempI++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempArray;
    }

    // Objects:
    public static String[] getShObjects() {
        return shObjects;
    }

    public static String[] getShObjects2ForShObjects_1() {
        return shObjects2ForShObjects_1;
    }

    public static String[] getShObjects2ForShObjects_2() {
        return shObjects2ForShObjects_2;
    }

    public static String[] getShObjects2ForShObjects_3() {
        return shObjects2ForShObjects_3;
    }

    public static String[] getShObjects2ForShObjects_4() {
        return shObjects2ForShObjects_4;
    }

    public static String[] getShObjects2ForShObjects_5() {
        return shObjects2ForShObjects_5;
    }

    public static String[] getShObjects2ForShObjects_6() {
        return shObjects2ForShObjects_6;
    }

    public static String[] getShObjects2ForShObjects_7() {
        return shObjects2ForShObjects_7;
    }

    public static String[] getShObjects2ForShObjects_8() {
        return shObjects2ForShObjects_8;
    }

    // Elements:
    public static String[] getShElementsForShObjects_1() {
        return shElementsForShObjects_1;
    }

    public static String[] getShElementsForShObjects_2() {
        return shElementsForShObjects_2;
    }

    public static String[] getShElementsForShObjects_3() {
        return shElementsForShObjects_3;
    }

    public static String[] getShElementsForShObjects_4() {
        return shElementsForShObjects_4;
    }

    public static String[] getShElementsForShObjects_5() {
        return shElementsForShObjects_5;
    }

    public static String[] getShElementsForShObjects_6() {
        return shElementsForShObjects_6;
    }

    public static String[] getShElementsForShObjects_7() {
        return shElementsForShObjects_7;
    }

    public static String[] getShElementsForShObjects_8() {
        return shElementsForShObjects_8;
    }

    public static String[] getShElementsForShObjects_9() {
        return shElementsForShObjects_9;
    }

    public static String[] getRelayEquipment() {
        return relayEquipment;
    }

    public static String[] getObjectsContactlessDevices() {
        return objectsContactlessDevices;
    }

    public static String[] getCondensingUnits() {
        return condensingUnits;
    }

    public static String[] getRectifiers() {
        return rectifiers;
    }

    public static String[] getTransformers() {
        return transformers;
    }

    public static String[] getProtectiveUnits() {
        return protectiveUnits;
    }

    public static String[] getSecurityFeatures() {
        return securityFeatures;
    }

    public static String[] getOtherElementsStative() {
        return otherElementsStative;
    }

    public static String[] getOtherElementsElectricitySupplyInstallations() {
        return otherElementsElectricitySupplyInstallations;
    }

    public static String[] getOtherElementsRackAndPinionRange() {
        return otherElementsRackAndPinionRange;
    }

    // Element-2:
    public static String[] getRelayEquipmentForElement2() {
        return relayEquipmentForElement2;
    }

    public static String[] getObjectsContactlessDevicesForElement2() {
        return objectsContactlessDevicesForElement2;
    }

    public static String[] getTransformersForElement2() {
        return transformersForElement2;
    }

    public static String[] getSecurityFeaturesForElement2() {
        return securityFeaturesForElement2;
    }

    // Reason-1:
    public static String[] getShReasons1ForShObjects_1() {
        return shReasons1ForShObjects_1;
    }

    public static String[] getReasonForRelayEquipment() {
        return reasonForRelayEquipment;
    }

    public static String[] getReasonForObjectsContactlessDevices() {
        return reasonForObjectsContactlessDevices;
    }

    public static String[] getReasonForTransformers() {
        return reasonForTransformers;
    }

    public static String[] getReasonForSecurityFeatures() {
        return reasonForSecurityFeatures;
    }

    public static String[] getReasonForOtherElementsStative() {
        return reasonForOtherElementsStative;
    }

    public static String[] getReasonForOtherElementsElectricitySupplyInstallations() {
        return reasonForOtherElementsElectricitySupplyInstallations;
    }

    public static String[] getShReasons1ForShObjects_4() {
        return shReasons1ForShObjects_4;
    }

    public static String[] getShReasons1ForShObjects_5() {
        return shReasons1ForShObjects_5;
    }

    public static String[] getShReasons1ForShObjects_6() {
        return shReasons1ForShObjects_6;
    }

    public static String[] getShReasons1ForShObjects_7() {
        return shReasons1ForShObjects_7;
    }

    public static String[] getShReasons1ForShObjects_8() {
        return shReasons1ForShObjects_8;
    }

    public static String[] getReasonForOtherElementsRackAndPinionRange() {
        return reasonForOtherElementsRackAndPinionRange;
    }

    // Reason-2:
    public static String[] getShReasons2() {
        return shReasons2;
    }

    public static String[] getShReasons2OperationalReasons() {
        return shReasons2OperationalReasons;
    }
}
