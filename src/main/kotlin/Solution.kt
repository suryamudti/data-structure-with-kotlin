fun List<Long>.hasPairOfSum(sum: Long): Boolean =
    indices.any { itemA ->
        indices.any { itemB ->
            itemA != itemB && this[itemA] + this[itemB] == sum
        }
    }