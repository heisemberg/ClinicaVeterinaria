from rest_framework.routers import DefaultRouter

from authApp.api.api import UserViewSet

router = DefaultRouter()

router.register(r'usuarios', UserViewSet, basename="users")

urlpatterns = router.urls