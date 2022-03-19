package io.github.yusufsdiscordbot.yusufsdiscordcore.bot.music.backend;

public enum Volume {
    // goes from 0 to 100
    ZERO_PERCENT(0),
    ONE_PERCENT(1),
    TWO_PERCENT(2),
    THREE_PERCENT(3),
    FOUR_PERCENT(4),
    FIVE_PERCENT(5),
    SIX_PERCENT(6),
    SEVEN_PERCENT(7),
    EIGHT_PERCENT(8),
    NINE_PERCENT(9),
    TEN_PERCENT(10),
    ELEVEN_PERCENT(11),
    TWELVE_PERCENT(12),
    THIRTEEN_PERCENT(13),
    FOURTEEN_PERCENT(14),
    FIFTEEN_PERCENT(15),
    SIXTEEN_PERCENT(16),
    SEVENTEEN_PERCENT(17),
    EIGHTEEN_PERCENT(18),
    NINETEEN_PERCENT(19),
    TWENTY_PERCENT(20),
    TWENTY_ONE_PERCENT(21),
    TWENTY_TWO_PERCENT(22),
    TWENTY_THREE_PERCENT(23),
    TWENTY_FOUR_PERCENT(24),
    TWENTY_FIVE_PERCENT(25),
    TWENTY_SIX_PERCENT(26),
    TWENTY_SEVEN_PERCENT(27),
    TWENTY_EIGHT_PERCENT(28),
    TWENTY_NINE_PERCENT(29),
    THIRTY_PERCENT(30),
    THIRTY_ONE_PERCENT(31),
    THIRTY_TWO_PERCENT(32),
    THIRTY_THREE_PERCENT(33),
    THIRTY_FOUR_PERCENT(34),
    THIRTY_FIVE_PERCENT(35),
    THIRTY_SIX_PERCENT(36),
    THIRTY_SEVEN_PERCENT(37),
    THIRTY_EIGHT_PERCENT(38),
    THIRTY_NINE_PERCENT(39),
    FORTY_PERCENT(40),
    FORTY_ONE_PERCENT(41),
    FORTY_TWO_PERCENT(42),
    FORTY_THREE_PERCENT(43),
    FORTY_FOUR_PERCENT(44),
    FORTY_FIVE_PERCENT(45),
    FORTY_SIX_PERCENT(46),
    FORTY_SEVEN_PERCENT(47),
    FORTY_EIGHT_PERCENT(48),
    FORTY_NINE_PERCENT(49),
    FIFTY_PERCENT(50),
    FIFTY_ONE_PERCENT(51),
    FIFTY_TWO_PERCENT(52),
    FIFTY_THREE_PERCENT(53),
    FIFTY_FOUR_PERCENT(54),
    FIFTY_FIVE_PERCENT(55),
    FIFTY_SIX_PERCENT(56),
    FIFTY_SEVEN_PERCENT(57),
    FIFTY_EIGHT_PERCENT(58),
    FIFTY_NINE_PERCENT(59),
    SIXTY_PERCENT(60),
    SIXTY_ONE_PERCENT(61),
    SIXTY_TWO_PERCENT(62),
    SIXTY_THREE_PERCENT(63),
    SIXTY_FOUR_PERCENT(64),
    SIXTY_FIVE_PERCENT(65),
    SIXTY_SIX_PERCENT(66),
    SIXTY_SEVEN_PERCENT(67),
    SIXTY_EIGHT_PERCENT(68),
    SIXTY_NINE_PERCENT(69),
    SEVENTY_PERCENT(70),
    SEVENTY_ONE_PERCENT(71),
    SEVENTY_TWO_PERCENT(72),
    SEVENTY_THREE_PERCENT(73),
    SEVENTY_FOUR_PERCENT(74),
    SEVENTY_FIVE_PERCENT(75),
    SEVENTY_SIX_PERCENT(76),
    SEVENTY_SEVEN_PERCENT(77),
    SEVENTY_EIGHT_PERCENT(78),
    SEVENTY_NINE_PERCENT(79),
    EIGHTY_PERCENT(80),
    EIGHTY_ONE_PERCENT(81),
    EIGHTY_TWO_PERCENT(82),
    EIGHTY_THREE_PERCENT(83),
    EIGHTY_FOUR_PERCENT(84),
    EIGHTY_FIVE_PERCENT(85),
    EIGHTY_SIX_PERCENT(86),
    EIGHTY_SEVEN_PERCENT(87),
    EIGHTY_EIGHT_PERCENT(88),
    EIGHTY_NINE_PERCENT(89),
    NINETY_PERCENT(90),
    NINETY_ONE_PERCENT(91),
    NINETY_TWO_PERCENT(92),
    NINETY_THREE_PERCENT(93),
    NINETY_FOUR_PERCENT(94),
    NINETY_FIVE_PERCENT(95),
    NINETY_SIX_PERCENT(96),
    NINETY_SEVEN_PERCENT(97),
    NINETY_EIGHT_PERCENT(98),
    NINETY_NINE_PERCENT(99),
    HUNDRED_PERCENT(100);

    private final int volume;

    Volume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public Volume setVolume(int volume) {
        return Volume.values()[volume];
    }
}
