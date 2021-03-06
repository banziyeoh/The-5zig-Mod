import com.google.common.collect.Multimap;
import eu.the5zig.mod.MinecraftFactory;
import eu.the5zig.mod.gui.ingame.ItemStack;
import eu.the5zig.mod.util.GLUtil;
import eu.the5zig.util.minecraft.ChatColor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 5zig.
 * All rights reserved © 2015
 */
public class WrappedItemStack implements ItemStack {

	private static final UUID ITEM_MODIFIER_UUID = UUID.fromString("cb3f55d3-645c-4f38-a497-9c13a33db5cf");

	private ain item;

	public WrappedItemStack(ain item) {
		this.item = item;
	}

	@Override
	public int getAmount() {
		return item.E();
	}

	@Override
	public int getMaxDurability() {
		return item.k();
	}

	@Override
	public int getCurrentDurability() {
		return item.i();
	}

	@Override
	public String getKey() {
		return getResourceKey(item);
	}

	@Override
	public String getDisplayName() {
		return item.r();
	}

	@Override
	public List<String> getLore() {
		return item.a(((Variables) MinecraftFactory.getVars()).getPlayer(), ajz.a.a);
	}

	@Override
	public int getHealAmount() {
		return item.c() instanceof aih ? ((aih) item.c()).h(item) : 0;
	}

	@Override
	public float getSaturationModifier() {
		return item.c() instanceof aih ? ((aih) item.c()).i(item) : 0;
	}

	@Override
	public void render(int x, int y, boolean withGenericAttributes) {
		if (item == null)
			return;
		((Variables) MinecraftFactory.getVars()).renderItem(item, x, y);

		if (withGenericAttributes) {
			for (vj modifier : vj.values()) {
				Multimap<String, wc> multimap = item.a(modifier);
				for (Map.Entry<String, wc> entry : multimap.entries()) {
					wc attribute = entry.getValue();
					double value = attribute.d();
					if (ITEM_MODIFIER_UUID.equals(attribute.a())) {
						if (((Variables) MinecraftFactory.getVars()).getPlayer() == null) {
							value += 1;
							value += (double) alk.a(item, vs.a);
						} else {
							value += ((Variables) MinecraftFactory.getVars()).getPlayer().a(adf.f).b();
							value += (double) alk.a(item, vs.a);
						}
					}
					if (entry.getKey().equals("generic.attackDamage") || entry.getKey().equals("generic.armor")) {
						GLUtil.disableDepth();
						GLUtil.pushMatrix();
						GLUtil.translate(x + 8, y + 10, 1);
						GLUtil.scale(0.7f, 0.7f, 0.7f);
						MinecraftFactory.getVars().drawString(ChatColor.BLUE + "+" + Math.round(value), 0, 0);
						GLUtil.popMatrix();
						GLUtil.enableDepth();
					}
				}
			}
		}
	}

	public static String getResourceKey(ain item) {
		nd resourceLocation = ail.g.b(item.c());
		return resourceLocation == null ? null : resourceLocation.toString();
	}
}
