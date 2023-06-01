using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEditor;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ObtenerAnimal : MonoBehaviour
{
    [Header("Tipos de GameObjects")]
    public GameObject player;
    public GameObject Perro;
    public GameObject Gato;
    public bool isPerro;
    public bool isGato;

    [Header("Sprites a Cambiar Perro")]
    public SpriteRenderer CabezaP;
    public SpriteRenderer CuerpoP;
    public SpriteRenderer PataIzquierdaP;
    public SpriteRenderer PataDerechaP;
    public SpriteRenderer PataIzquierdaIP;
    public SpriteRenderer PataDerechaIP;
    public SpriteRenderer ColaP;

    [Header("Sprites a Cambiar Gato")]
    public SpriteRenderer CabezaC;
    public SpriteRenderer CuerpoC;
    public SpriteRenderer PataIzquierdaC;
    public SpriteRenderer PataDerechaC;
    public SpriteRenderer PataIzquierdaIC;
    public SpriteRenderer PataDerechaIC;
    public SpriteRenderer ColaC;

    [Header("Lista de apariencias Perro")]
    public List<Sprite> listaRopaCabezaP = new List<Sprite>();
    public List<Sprite> listaRopaCuerpoP = new List<Sprite>();
    public List<Sprite> listaRopaPataIzquierdaP = new List<Sprite>();
    public List<Sprite> listaRopaPataDerechaP = new List<Sprite>();
    public List<Sprite> listaRopaPataIzquierdaIP = new List<Sprite>();
    public List<Sprite> listaRopaPataDerechaIP = new List<Sprite>();
    public List<Sprite> listaRopaColaP = new List<Sprite>();

    [Header("Lista de apariencias Gato")]
    public List<Sprite> listaRopaCabezaC = new List<Sprite>();
    public List<Sprite> listaRopaCuerpoC = new List<Sprite>();
    public List<Sprite> listaRopaPataIzquierdaC = new List<Sprite>();
    public List<Sprite> listaRopaPataDerechaC = new List<Sprite>();
    public List<Sprite> listaRopaPataIzquierdaIC = new List<Sprite>();
    public List<Sprite> listaRopaPataDerechaIC = new List<Sprite>();
    public List<Sprite> listaRopaColaC = new List<Sprite>();

    [Header("Opciones Perro")]
    public int opcioncontador1P = 0;
    public int opcioncontador2P = 0;
    public int opcioncontador3P = 0;
    public int opcioncontador4P = 0;
    public int opcioncontador5P = 0;
    public int opcioncontador6P = 0;
    public int opcioncontador7P = 0;

    [Header("Opciones Gato")]
    public int opcioncontador1C = 0;
    public int opcioncontador2C = 0;
    public int opcioncontador3C = 0;
    public int opcioncontador4C = 0;
    public int opcioncontador5C = 0;
    public int opcioncontador6C = 0;
    public int opcioncontador7C = 0;

    void Update()
    {
        if (isGato)
        {      
            isPerro = false;
        }
        else
        {
            isPerro = true;
        }

        Perro.SetActive(isPerro);
        Gato.SetActive(isGato);
        //obtencion skin gato
        CabezaC.sprite = listaRopaCabezaC[opcioncontador1C];
        CuerpoC.sprite = listaRopaCuerpoC[opcioncontador2C];
        PataIzquierdaC.sprite = listaRopaPataIzquierdaC[opcioncontador3C];
        PataDerechaC.sprite = listaRopaPataDerechaC[opcioncontador4C];
        PataIzquierdaIC.sprite = listaRopaPataIzquierdaIC[opcioncontador5C];
        PataDerechaIC.sprite = listaRopaPataDerechaIC[opcioncontador6C];
        ColaC.sprite = listaRopaColaC[opcioncontador7C];

        //obtencion skin perro
        CabezaP.sprite = listaRopaCabezaP[opcioncontador1P];
        CuerpoP.sprite = listaRopaCuerpoP[opcioncontador2P];
        PataIzquierdaP.sprite = listaRopaPataIzquierdaP[opcioncontador3P];
        PataDerechaP.sprite = listaRopaPataDerechaP[opcioncontador4P];
        PataIzquierdaIP.sprite = listaRopaPataIzquierdaIP[opcioncontador5P];
        PataDerechaIP.sprite = listaRopaPataDerechaIP[opcioncontador6P];
        ColaP.sprite = listaRopaColaP[opcioncontador7P];
    }
}
