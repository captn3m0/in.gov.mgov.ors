package nitesh.floatinghint;

 enum FloatingHintEditText$Animation
{
  static
  {
    int i = 2;
    int j = 1;
    Object localObject = new nitesh/floatinghint/FloatingHintEditText$Animation;
    ((Animation)localObject).<init>("NONE", 0);
    NONE = (Animation)localObject;
    localObject = new nitesh/floatinghint/FloatingHintEditText$Animation;
    ((Animation)localObject).<init>("SHRINK", j);
    SHRINK = (Animation)localObject;
    localObject = new nitesh/floatinghint/FloatingHintEditText$Animation;
    ((Animation)localObject).<init>("GROW", i);
    GROW = (Animation)localObject;
    localObject = new Animation[3];
    Animation localAnimation = NONE;
    localObject[0] = localAnimation;
    localAnimation = SHRINK;
    localObject[j] = localAnimation;
    localAnimation = GROW;
    localObject[i] = localAnimation;
    $VALUES = (Animation[])localObject;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/nitesh/floatinghint/FloatingHintEditText$Animation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */