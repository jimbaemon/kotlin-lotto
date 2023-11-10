package lotto.domain

enum class Rank(val matchCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_RANK(0, 0);

    companion object {
        fun from(matchCount: Int, matchBonus: Boolean): Rank {
            return values().filter {
                it.matchCount == matchCount
            }.firstOrNull {
                if (it.matchCount == 5 && !matchBonus) {
                    return THIRD
                }
                return it
            } ?: NO_RANK
        }
    }
}
