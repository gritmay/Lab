
package EnemyFabric;

import AllEnemies.Baraka;
import EnemyFabric.EnemyFabricInterface;
import mortalkombatbversion.Player;



/**
 *
 * @author Мария
 */
public class BarakaFabric implements EnemyFabricInterface {

    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new Baraka(1, 100, 12, 1);
        return enemy;
    }
}
