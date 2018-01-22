package cpebud.hcm.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelGiantChicken - cpebud
 * Created using Tabula 7.0.0
 */
public class ModelChickenGiant extends ModelBase {
    public ModelRenderer foot_right;
    public ModelRenderer foot_left;
    public ModelRenderer leg_right;
    public ModelRenderer leg_left;
    public ModelRenderer body;
    public ModelRenderer wing_left;
    public ModelRenderer wing_right;
    public ModelRenderer head;
    public ModelRenderer beak;
    public ModelRenderer gobbler;

    public ModelChickenGiant() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.beak = new ModelRenderer(this, 56, 0);
        this.beak.setRotationPoint(0.0F, -16.0F, 16.0F);
        this.beak.addBox(-8.0F, -16.0F, 8.0F, 16, 8, 8, 0.0F);
        this.gobbler = new ModelRenderer(this, 56, 16);
        this.gobbler.setRotationPoint(0.0F, -16.0F, 16.0F);
        this.gobbler.addBox(-4.0F, -8.0F, 4.0F, 8, 8, 8, 0.0F);
        this.wing_right = new ModelRenderer(this, 72, 18);
        this.wing_right.setRotationPoint(16.0F, -24.0F, 0.0F);
        this.wing_right.addBox(-4.0F, 0.0F, -12.0F, 4, 16, 24, 0.0F);
        this.foot_left = new ModelRenderer(this, 104, 0);
        this.foot_left.setRotationPoint(-6.0F, 0.0F, -2.0F);
        this.foot_left.addBox(-6.0F, 20.0F, 2.0F, 12, 4, 8, 0.0F);
        this.leg_right = new ModelRenderer(this, 110, 12);
        this.leg_right.setRotationPoint(6.0F, 0.0F, -2.0F);
        this.leg_right.addBox(-2.0F, 0.0F, -2.0F, 4, 24, 4, 0.0F);
        this.body = new ModelRenderer(this, 0, 36);
        this.body.setRotationPoint(0.0F, -12.0F, 0.0F);
        this.body.addBox(-12.0F, -16.0F, -12.0F, 24, 32, 24, 0.0F);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.wing_left = new ModelRenderer(this, 72, 18);
        this.wing_left.setRotationPoint(-16.0F, -24.0F, 0.0F);
        this.wing_left.addBox(0.0F, 0.0F, -12.0F, 4, 16, 24, 0.0F);
        this.foot_right = new ModelRenderer(this, 104, 0);
        this.foot_right.setRotationPoint(6.0F, 0.0F, -2.0F);
        this.foot_right.addBox(-6.0F, 20.0F, 2.0F, 12, 4, 8, 0.0F);
        this.leg_left = new ModelRenderer(this, 110, 12);
        this.leg_left.setRotationPoint(-6.0F, 0.0F, -2.0F);
        this.leg_left.addBox(-2.0F, 0.0F, -2.0F, 4, 24, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -16.0F, 16.0F);
        this.head.addBox(-8.0F, -24.0F, -4.0F, 16, 24, 12, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.beak.render(f5);
        this.gobbler.render(f5);
        this.wing_right.render(f5);
        this.foot_left.render(f5);
        this.leg_right.render(f5);
        this.body.render(f5);
        this.wing_left.render(f5);
        this.foot_right.render(f5);
        this.leg_left.render(f5);
        this.head.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
