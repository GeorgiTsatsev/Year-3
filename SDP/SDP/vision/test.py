import pygame, cv
src = cv.LoadImage("foo.jpg")
src_rgb = cv.CreateMat(src.height, src.width, cv.CV_8UC3)
cv.CvtColor(src, src_rgb, cv.CV_BGR2RGB)
pg_img = pygame.image.frombuffer(src_rgb.tostring(), cv.GetSize(src_rgb), "RGB")
print pg_img
