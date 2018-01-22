package cpebud.hcm.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelGiantChickenBase - cpebud
 * Created using Tabula 7.0.0
 */
public class ModelChickenGiantBase extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer bill;
    public ModelRenderer chin;
    public ModelRenderer leftLeg;
    public ModelRenderer rightLeg;
    public ModelRenderer leftFoot;
    public ModelRenderer rightFoot;
    public ModelRenderer leftWing;
    public ModelRenderer rightWing;

    public ModelChickenGiantBase() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.body = new ModelRenderer(this, 0, 36);
        this.body.setRotationPoint(0.0F, -12.0F, 0.0F);
        this.body.addBox(-12.0F, -16.0F, -12.0F, 24, 32, 24, 0.0F);
        this.rightLeg = new ModelRenderer(this, 110, 12);
        this.rightLeg.setRotationPoint(-6.0F, 0.0F, 2.0F);
        this.rightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 24, 4, 0.0F);
        this.leftWing = new ModelRenderer(this, 72, 18);
        this.leftWing.setRotationPoint(16.0F, -24.0F, 0.0F);
        this.leftWing.addBox(-4.0F, 0.0F, -12.0F, 4, 16, 24, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -16.0F, -16.0F);
        this.head.addBox(-8.0F, -24.0F, -8.0F, 16, 24, 12, 0.0F);
        this.bill = new ModelRenderer(this, 56, 0);
        this.bill.setRotationPoint(0.0F, -16.0F, -16.0F);
        this.bill.addBox(-8.0F, -16.0F, -16.0F, 16, 8, 8, 0.0F);
        this.leftFoot = new ModelRenderer(this, 104, 0);
        this.leftFoot.setRotationPoint(6.0F, 0.0F, 2.0F);
        this.leftFoot.addBox(-6.0F, 20.0F, -10.0F, 12, 4, 8, 0.0F);
        this.rightWing = new ModelRenderer(this, 72, 18);
        this.rightWing.setRotationPoint(-16.0F, -24.0F, 0.0F);
        this.rightWing.addBox(0.0F, 0.0F, -12.0F, 4, 16, 24, 0.0F);
        this.chin = new ModelRenderer(this, 56, 16);
        this.chin.setRotationPoint(0.0F, -16.0F, -16.0F);
        this.chin.addBox(-4.0F, -8.0F, -12.0F, 8, 8, 8, 0.0F);
        this.leftLeg = new ModelRenderer(this, 110, 12);
        this.leftLeg.setRotationPoint(6.0F, 0.0F, 2.0F);
        this.leftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 24, 4, 0.0F);
        this.rightFoot = new ModelRenderer(this, 104, 0);
        this.rightFoot.setRotationPoint(-6.0F, 0.0F, 2.0F);
        this.rightFoot.addBox(-6.0F, 20.0F, -10.0F, 12, 4, 8, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);

        if (this.isChild)
        {
            float f = 2.0F;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 5.0F * scale, 2.0F * scale);
            this.head.render(scale);
            this.bill.render(scale);
            this.chin.render(scale);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
            this.body.render(scale);
            this.rightLeg.render(scale);
            this.leftLeg.render(scale);
            this.rightFoot.render(scale);
            this.leftFoot.render(scale);
            this.rightWing.render(scale);
            this.leftWing.render(scale);
            GlStateManager.popMatrix();
        }
        else
        {
            this.head.render(scale);
            this.bill.render(scale);
            this.chin.render(scale);
            this.body.render(scale);
            this.rightLeg.render(scale);
            this.leftLeg.render(scale);
            this.rightFoot.render(scale);
            this.leftFoot.render(scale);
            this.rightWing.render(scale);
            this.leftWing.render(scale);
        }
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.bill.rotateAngleX = this.head.rotateAngleX;
        this.bill.rotateAngleY = this.head.rotateAngleY;
        this.chin.rotateAngleX = this.head.rotateAngleX;
        this.chin.rotateAngleY = this.head.rotateAngleY;
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightFoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftFoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightWing.rotateAngleZ = ageInTicks;
        this.leftWing.rotateAngleZ = -ageInTicks;
    }
}
