from django.db import models
from django.contrib.auth.models import AbstractBaseUser, PermissionsMixin, BaseUserManager

class UserManager(BaseUserManager):
    def _create_user(self, username, nombres, apellidos,  especialidad, email, telefono,  password, is_staff, is_superuser, **extra_fields):
        if not username:
            raise ValueError('Users must have an username')
        user = self.model(
            username=username,
            nombres=nombres,
            apellidos=apellidos,
            especialidad=especialidad,
            email=email,
            telefono=telefono,
            is_staff=is_staff,
            is_superuser=is_superuser,
            **extra_fields
            )
        user.set_password(password)
        user.save(using=self._db)
        return user
    
    def create_user(self, username, nombres, apellidos, especialidad, email, telefono,  password=None, **extra_fields):
        return self._create_user(username, nombres, apellidos,  especialidad, email, telefono, password, False, False, **extra_fields)
          
    def create_superuser(self,  username, nombres, apellidos,  especialidad, email, telefono, password=None, **extra_fields):
        return self._create_user(username, nombres, apellidos,  especialidad, email, telefono, password, True, True, **extra_fields)

class User(AbstractBaseUser, PermissionsMixin):
    id = models.BigAutoField(primary_key=True)
    username = models.CharField('Username', max_length = 50, unique=True)
    nombres = models.CharField('Nombres', max_length = 50, blank=True)
    apellidos = models.CharField('Apellidos', max_length = 50, blank=True)
    especialidad = models.CharField('Especialidad', max_length = 50, blank=True)
    email = models.EmailField('Email', max_length = 100, default=None, unique=True)
    telefono = models.BigIntegerField('Telefono', default = None, blank=True, null=True )
    password = models.CharField('Password', max_length = 256)
    is_active = models.BooleanField(default=True)
    is_staff = models.BooleanField(default=False)
    objects = UserManager()

    class Meta:
        verbose_name = 'Usuario'
        verbose_name_plural = 'Usuarios'
        ordering = ['username']
    
    USERNAME_FIELD = 'username'
    REQUIRED_FIELDS = ['nombres', 'apellidos', 'especialidad', 'email', 'telefono']

    def natural_key(self):
        return (self.username)
        
    def __str__(self):
        return f'{self.nombres} {self.apellidos}'