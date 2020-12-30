RPG Combat Kata
================

# Background #

This is a fun kata that has the programmer building simple combat rules, as for a role-playing game (RPG). It is implemented as a sequence of iterations. The domain doesn't include a map or any other character skills apart from their ability to damage and heal one another.

Complete each iteration before reading the next one. You may fix a time limit for each iteration as a constraint.

## Iteration One ##

1. All Characters, when created, have:
	- Health, starting at 1000
	- Level, starting at 1
	- May be alive or dead, starting alive

1. Characters can deal damage to characters.
	- Damage is subtracted from health
	- When damage received is greater than or equal to the current health, health becomes 0 and the character dies

1. A character can heal a character.
	- Dead characters cannot be healed
	- Healing cannot raise health above 1000

## Iteration Two ##

1. The player can deal damage to his enemies, but not to himself.

1. The player can heal himself, but not his enemies.

1. The level now has an effect on the damage applied:
	- If the target is 5 or more levels above the attacker, damage is reduced by 50%
	- If the target is 5 or more levels below the attacker, damage is increased by 50%

## Iteration Three ##

1. The player has an attack range.

1. *Melee* fighters have a range of 2 meters.

1. *Ranged* fighters have a range of 20 meters.

1. When trying to deal damage, the player must be in range.

## Retrospective ##

- Are you keeping up with the requirements? Has any iteration been a big challenge?
- Do you feel good about your design? Is it scalable and easily adapted to new requirements that will be introduced in the last iterations?
- Is everything tested and are you confident in your tests?

## Iteration Four ##

1. Characters may belong to one or more factions. Newly created characters belong to no faction.

1. A character may join or leave one or more factions.

1. Players belonging to the same faction are considered allies.

1. Allies cannot deal damage to one another.

1. Allies can heal one another.

## Iteration Five ##

Finally, the player can damage other things that are not characters, called objects. This means that he can attack a house, a tree or anything else that has some health

1. Characters can damage objects.
	- Therefore, anything that has Health may be damaged by a character
	- Objects do not have a level
	- Objects can only be damaged by players who are in range
	- Objects cannot be healed and they do not deal damage
	- Objects do not belong to factions; they are neutral
	- When reduced to 0 health, objects are *destroyed*
	- As an example, you may create a tree object with 2000 health


## Retrospective ##

- What problems did you encounter?
- What have you learned? Any new technique or pattern?
- Share your design with others, and get feedback on different approaches.
