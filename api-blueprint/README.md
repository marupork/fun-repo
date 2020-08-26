# api blueprint

## Generate HTML

```console
aglio -i message.apib --theme-template triple -o message.html
```

## Mock server

```console
drakov -f ./message.apib -p 3000
```

### Reference

- [apiblueprint.org Tutorial](https://apiblueprint.org/documentation/tutorial.html)
- [MSON](https://apiblueprint.org/documentation/mson/tutorial.html)