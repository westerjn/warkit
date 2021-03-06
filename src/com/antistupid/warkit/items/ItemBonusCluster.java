package com.antistupid.warkit.items;

import com.antistupid.warbase.structs.StatAlloc;
import java.util.Arrays;
import java.util.Comparator;
import com.antistupid.warbase.types.QualityT;
import com.antistupid.warbase.types.SocketT;

public class ItemBonusCluster {
        
    static public final Comparator<ItemBonusCluster> CMP_ITEM_LEVEL = (a, b) -> a.itemLevelDelta - b.itemLevelDelta;
    
    static public final ItemBonusCluster NONE = new ItemBonusCluster(new ItemBonus[0], "None", 0, 0, null, null, null);
          
    public final ItemBonus[] components; // never null, sorted by id
    public final String name;
    public final int itemLevelDelta;
    public final int reqLevelDelta;
    public final QualityT quality; // can be null
    public final StatAlloc[] statAllocs; // can be null
    public final SocketT[] sockets; // can be null

    public ItemBonusCluster(ItemBonus[] components, String name, int itemLevelDelta, int reqLevelDelta, QualityT quality, StatAlloc[] statAllocs, SocketT[] sockets) {
        this.components = components;
        this.name = name;
        this.itemLevelDelta = itemLevelDelta;
        this.reqLevelDelta = reqLevelDelta;     
        this.quality = quality;
        this.statAllocs = statAllocs;
        this.sockets = sockets;
    }
    
    public boolean containsBonus(int id) {
        return findBonus(id) >= 0;
    }
    
    public int findBonus(int id) {
        for (int i = 0; i < components.length; i++) {
            if (components[i].id == id) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public String toString() {
        return String.format("%s(%s,%d,%d,%s)%s", getClass().getSimpleName(), name, itemLevelDelta, reqLevelDelta, quality, Arrays.toString(components));
    }
    
    
}
