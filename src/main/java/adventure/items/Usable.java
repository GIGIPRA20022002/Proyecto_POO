package adventure.items;

import adventure.characters.Character;

public interface Usable {
    String use(Character user, Character target);
}