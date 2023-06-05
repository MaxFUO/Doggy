using System.Collections;
using System.Collections.Generic;
using UnityEditor;
using UnityEditor.SceneManagement;
using UnityEngine;
using UnityEngine.Events;
using UnityEngine.PlayerLoop;
using UnityEngine.SceneManagement;
using UnityEngine.UI;
using UnityEngine.UIElements;

public class GameManager : MonoBehaviour
{
    public enum EstadosdelJuego { INICIO, TIENDA, ADOPTAR, COMIDA, BAÑO, COMUNIDAD, RANKING, ROPA, PLAY }
    public EstadosdelJuego estado;

    public GameObject player;

    public Text txtNombreAnimal;
    public string textoRecuperado;
    public int idAnimalObetenido;

    private void Awake()
    {
        StartCoroutine(ObtenerAnimal());
    }
    public void scenCargar(string nombreNivel)
    {
        SceneManager.LoadScene(nombreNivel);
    }

    public void enviarPlayer(string nombreNivel)
    {
        PrefabUtility.SaveAsPrefabAsset(player, "Assets/Prefabs/Animal.prefab");
        SceneManager.LoadScene(nombreNivel);
    }

    IEnumerator ObtenerAnimal()
    {
        WWW conexion = new WWW("http://140.84.189.249/consultaranimaljuego.php?ID_Animal=" + idAnimalObetenido);
        yield return conexion;

        string[] nDatos = conexion.text.Split("|");

        textoRecuperado = nDatos[1];
        txtNombreAnimal.text = textoRecuperado;
    }
}
